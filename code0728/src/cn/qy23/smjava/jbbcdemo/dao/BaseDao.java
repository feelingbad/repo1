package cn.qy23.smjava.jbbcdemo.dao;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/28 19:36
 */
public interface BaseDao<T> {
    /**
     *  插入一条记录
     * @param t 传入一个entity类实体将其中的成员变量的数据插入数据库对应的表中各个字段
     * @return
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    int insert(T t) throws KeyNotFoundException, SQLException;

    /**
     *删除一条记录
     * @param id sql语句中where xx = id
     * @return
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    int delete(Integer id) throws KeyNotFoundException, SQLException;

    /**
     *更新一条记录
     * @param t 传入一个entity类实体，其中的成员变量的数据将更新数据库对应的表中各个字段
     * @return
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    int update(T t) throws KeyNotFoundException, SQLException;

    /**
     *选择一条记录
     * @param id sql语句中where xx = id
     * @return
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    T selectOne(Integer id) throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

//    /**
//     *选择所有记录,用List<Map<String, Object>>接收
//     * @return
//     * @throws KeyNotFoundException
//     * @throws SQLException
//     */
//    List<Map<String, Object>> selectAll() throws KeyNotFoundException, SQLException;

    /**
     *选择所有记录,用List<T>接收
     * @return
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    List<T> selectAll1() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}