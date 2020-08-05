package cn.qy23.smjava.jbbcdemo.service.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.BaseDao;
import cn.qy23.smjava.jbbcdemo.dao.OrderDao;
import cn.qy23.smjava.jbbcdemo.entity.Order;
import cn.qy23.smjava.jbbcdemo.service.OrderService;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 15:46
 */
public class OrderServiceImpl extends CurdServiceImpl implements OrderService {
    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        super(orderDao);
        this.orderDao = orderDao;
    }

    @Override
    public int getKey(Order order) {
        try {
            Connection connection = DbUtil.getConn();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int num = 0;
        if (order != null) {
            try {
                num = orderDao.getKey(order);
            } catch (KeyNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("goodType is null!");
        }
        return num;
    }
}
