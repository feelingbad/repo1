package cn.qy23.smjava.jbbcdemo.service;

import cn.qy23.smjava.jbbcdemo.entity.Order;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 15:45
 */
public interface OrderService extends CurdService{
    int getKey(Order order);
}
