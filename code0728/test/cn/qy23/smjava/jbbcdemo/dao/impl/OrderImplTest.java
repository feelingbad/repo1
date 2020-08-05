package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.OrderDao;
import cn.qy23.smjava.jbbcdemo.entity.Order;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.*;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 15:50
 */
public class OrderImplTest {

    @Test
    public void insert() {

    }

    @Test
    public void selectOne() {
        OrderImpl order = new OrderImpl();
        try {
            System.out.println(order.selectOne(28));
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAll() {
    }

    @Test
    public void getKey() {
        Order order = new Order(1,2, BigDecimal.valueOf(500), Timestamp.from(Instant.now()),1);
        try {
            OrderImpl order1 = new OrderImpl();
            int i = order1.getKey(order);
            System.out.println(i);
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}