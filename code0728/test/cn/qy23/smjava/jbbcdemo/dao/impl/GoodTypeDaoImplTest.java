package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.GoodType;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;


/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/28 20:51
 */
public class GoodTypeDaoImplTest {

    @Test
    public void insert() throws KeyNotFoundException, SQLException {
        GoodTypeDaoImpl goodTypeDao = new GoodTypeDaoImpl();
        GoodType goodType = new GoodType(1,7,"新疆水果",false, Timestamp.from(Instant.now()),Timestamp.from(Instant.now()));
        System.out.println(goodTypeDao.insert(goodType));
    }

    @Test
    public void delete() throws KeyNotFoundException, SQLException {
        GoodTypeDaoImpl goodTypeDao = new GoodTypeDaoImpl();
        System.out.println(goodTypeDao.delete(1));
    }

    @Test
    public void update() throws KeyNotFoundException, SQLException {
        GoodType goodType = new GoodType(7,2,"本地水果",true, Timestamp.from(Instant.now()),Timestamp.from(Instant.now()));
        GoodTypeDaoImpl goodTypeDao = new GoodTypeDaoImpl();
        System.out.println(goodTypeDao.update(goodType));
    }

    @Test
    public void selectOne() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        GoodTypeDaoImpl goodTypeDao = new GoodTypeDaoImpl();
        System.out.println(goodTypeDao.selectOne(2));
    }


    @Test
    public void selectSon() throws KeyNotFoundException, SQLException {

    }
}