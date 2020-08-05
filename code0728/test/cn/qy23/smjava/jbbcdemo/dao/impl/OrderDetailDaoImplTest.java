package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.OrderDetail;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/27 17:40
 */
public class OrderDetailDaoImplTest {

    @Test
    public void insert() throws KeyNotFoundException, SQLException {
//        OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
//        OrderDetail orderDetail = new OrderDetail( 4, 5, 5);
//        orderDetailDaoImpl.insert(orderDetail);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        int size = orderDetailList.size();
        System.out.println(OrderDetail.class.getDeclaredFields().length);
    }

    @Test
    public void delete() throws KeyNotFoundException, SQLException {
        OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
        orderDetailDaoImpl.delete(1);
    }

    @Test
    public void update() throws KeyNotFoundException, SQLException {
        OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
        OrderDetail orderDetail = new OrderDetail(4,7,7);
        orderDetailDaoImpl.update(orderDetail);
    }

    @Test
    public void selectOne() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
        System.out.println(orderDetailDaoImpl.selectOne(2));
    }




    @Test
    public void selectOne1() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
        System.out.println(orderDetailDaoImpl.selectOne(2));
    }

    @Test
    public void selectAll1() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, KeyNotFoundException, InstantiationException, InvocationTargetException, SQLException {
        OrderDetailDaoImpl orderDetailDaoImpl = new OrderDetailDaoImpl();
        System.out.println(orderDetailDaoImpl.selectAll1());
    }

    @Test
    public void insertMore() {

    }
}