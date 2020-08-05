package cn.qy23.smjava.jbbcdemo.service.impl;


import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.BaseDao;

import cn.qy23.smjava.jbbcdemo.dao.OrderDetailDao;
import cn.qy23.smjava.jbbcdemo.entity.OrderDetail;
import cn.qy23.smjava.jbbcdemo.service.OrderDetailService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/28 16:50
 */
public class OrderDetailServiceImpl extends CurdServiceImpl implements OrderDetailService {
    private OrderDetailDao orderDetailDao;

    public OrderDetailServiceImpl(OrderDetailDao orderDetailDao) {
        super(orderDetailDao);
        this.orderDetailDao = orderDetailDao;
    }


    @Override
    public int insertMore(List<OrderDetail> orderDetailList) {
        int num = 0;
        try {
            num = orderDetailDao.insertMore(orderDetailList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
