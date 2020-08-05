package cn.qy23.smjava.jbbcdemo.util;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/27 14:29
 */
public class DbUtil {
    private static Properties properties;
    private static final ThreadLocal<Connection> CONNECTION_THREAD_LOCAL = new ThreadLocal<>();

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("resources/db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws KeyNotFoundException, SQLException {
        Connection connection = CONNECTION_THREAD_LOCAL.get();
        if (connection == null) {
            connection = DriverManager.getConnection(getPropertiesValue("url"), getPropertiesValue("user"), getPropertiesValue("password"));
            CONNECTION_THREAD_LOCAL.set(connection);
        }
        return connection;
    }

    public static int executeGetKey(String sql, Object... paras) throws KeyNotFoundException, SQLException {
        Connection connection = getConn();
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        if (paras != null && paras.length > 0) {
            for (int i = 0; i < paras.length; i++) {
                preparedStatement.setObject(i+1, paras[i]);
            }
        }
        int i = 0;
        preparedStatement.executeUpdate();
        ResultSet generateKeys = preparedStatement.getGeneratedKeys();
        if (generateKeys.next()) {
            i = generateKeys.getInt(1);
        }
        return i;
    }


    public static int executeUpdate(String sql, Object... paras) throws KeyNotFoundException, SQLException {
        Connection connection = getConn();
        int i = 0;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (paras != null && paras.length > 0) {
            for (int j = 0; j < paras.length; j++) {
                preparedStatement.setObject(j + 1, paras[j]);
            }
        }
        i = preparedStatement.executeUpdate();
        return i;
    }

    public static List<Map<String, Object>> executeQuery(String sql, Object... paras) throws KeyNotFoundException, SQLException {
        Connection connection = getConn();
        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (paras != null && paras.length > 0) {
            for (int i = 0; i < paras.length; i++) {
                preparedStatement.setObject(i + 1, paras[i]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        int columnCount = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            HashMap<String, Object> map = new HashMap<>(10);
            for (int i = 1; i <= columnCount; i++) {
                map.put(resultSet.getMetaData().getColumnName(i), resultSet.getObject(i));
            }
            resultList.add(map);
        }
        return resultList;
    }


    public static <T> List<T> executeQuery(String sql, Class<T> tClass, Object... paras) throws SQLException,
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, KeyNotFoundException {
        Connection conn = getConn();
        ArrayList<T> list = new ArrayList<>(10);
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        if (paras != null && paras.length > 0) {
            for (int i = 0; i < paras.length; i++) {
                preparedStatement.setObject(i + 1, paras[i]);
            }
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        int columnCount = resultSet.getMetaData().getColumnCount();
        Class[] paraTypes = new Class[columnCount];

        for (int i = 1; i <= columnCount; i++) {
            String columnClassName = resultSet.getMetaData().getColumnClassName(i);
            Class<?> aClass = Class.forName(columnClassName);
            paraTypes[i - 1] = aClass;
        }
        Constructor<T> declaredConstructor = tClass.getDeclaredConstructor(paraTypes);
        Object[] objects = new Object[columnCount];
        while (resultSet.next()) {
            for (int i = 1; i <= columnCount; i++) {
                objects[i - 1] = resultSet.getObject(i);
            }
            T t1 = declaredConstructor.newInstance(objects);
            list.add(t1);
        }
        return list;
    }

    public static void closeConn() throws SQLException {
        if (CONNECTION_THREAD_LOCAL.get() != null) {
            CONNECTION_THREAD_LOCAL.get().close();
            CONNECTION_THREAD_LOCAL.remove();
        }
    }


    public static String getPropertiesValue(String key) throws KeyNotFoundException {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            throw new KeyNotFoundException("配置文件中没有对应文件: " + key);
        }
    }
}
