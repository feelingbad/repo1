package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.Good;
import cn.qy23.smjava.jbbcdemo.entity.Order;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.*;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 9:57
 */
public class GoodDaoImplTest {

    @Test
    public void insert() throws KeyNotFoundException, SQLException {
        GoodDaoImpl goodDao = new GoodDaoImpl();
        Good good = new Good(3, "菠菜", 5, 5, 2.4F, 1, 9.4F, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));
        System.out.println(goodDao.insert(good));
    }

    @Test
    public void delete() throws KeyNotFoundException, SQLException {
        GoodDaoImpl goodDao = new GoodDaoImpl();
        System.out.println(goodDao.delete(2));
    }

    @Test
    public void update() throws KeyNotFoundException, SQLException {
        GoodDaoImpl goodDao = new GoodDaoImpl();
        Good good = new Good(2, "苹果", 2, 5, 2.4F, 1, 9.4F, Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));
        System.out.println(goodDao.update(good));
    }

    @Test
    public void selectOne() throws KeyNotFoundException, SQLException {
        GoodDaoImpl goodDao = new GoodDaoImpl();
        try {
            System.out.println(goodDao.selectOne(3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void selectAll1() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {


    }



}