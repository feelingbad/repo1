package cn.qy23.smjava.jbbcdemo.service;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/28 16:50
 */
public interface OrderDetailService extends CurdService{
    /**
     * 增加多条详情订单
     * @param orderDetailList
     * @return
     */
    int insertMore(List<OrderDetail> orderDetailList);
}
