package cn.qy23.smjava.jbbcdemo.dao;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.Order;

import java.sql.SQLException;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 9:30
 */
public interface OrderDao extends BaseDao<Order>{
    /**
     * 获得订单的主键
     * @param order
     * @return
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    int getKey(Order order)throws KeyNotFoundException, SQLException;
}
