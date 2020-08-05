package cn.qy23.smjava.jbbcdemo.dao;


import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 9:33
 */
public interface OrderDetailDao extends BaseDao<OrderDetail> {
    /**
     * 一次增加多条记录
     * @param orderDetailList
     * @return
     * @throws ClassNotFoundException
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    int insertMore(List<OrderDetail> orderDetailList) throws ClassNotFoundException, KeyNotFoundException, SQLException;
}
