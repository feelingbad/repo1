package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.OrderDao;
import cn.qy23.smjava.jbbcdemo.entity.Order;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 9:31
 */
public class OrderImpl implements OrderDao {

    @Override
    public int insert(Order order) throws KeyNotFoundException, SQLException {
        Integer userId = order.getUserId();
        BigDecimal orderAmount = order.getOrderAmount();
        Timestamp orderTime = order.getOrderTime();
        Integer payType = order.getPayType();
        String sql = "INSERT INTO t_order (uid,order_amount,order_time,pay_type) VALUES (?,?,?,?)";
        int i = DbUtil.executeUpdate(sql,userId,orderAmount,orderTime,payType);
        return i;
    }

    @Override
    public int getKey(Order order) throws KeyNotFoundException, SQLException {
        Integer userId = order.getUserId();
        BigDecimal orderAmount = order.getOrderAmount();
        Timestamp orderTime = order.getOrderTime();
        Integer payType = order.getPayType();
        String sql = "INSERT INTO t_order (uid,order_amount,order_time,pay_type) VALUES (?,?,?,?)";
        int i = DbUtil.executeGetKey(sql,userId,orderAmount,orderTime,payType);
        System.out.println("这里的key值为"+i);
        return i;
    }


    @Override
    public int delete(Integer id) throws KeyNotFoundException, SQLException {
        return 0;
    }

    @Override
    public int update(Order order) throws KeyNotFoundException, SQLException {
        return 0;
    }

    @Override
    public Order selectOne(Integer id) throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM t_order WHERE oid =?";
        List<Order> resultList = DbUtil.executeQuery(sql,Order.class,id);
        if (resultList.size() ==0) {
            return null;
        }
        return resultList.get(0);
    }

//    @Override
//    public List<Map<String, Object>> selectAll() throws KeyNotFoundException, SQLException {
//        String sql = "SELECT * FROM t_order";
//        List<Map<String, Object>> resultList = DbUtil.executeQuery(sql);
//        return resultList;
//    }

    @Override
    public List<Order> selectAll1() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM t_order";
        List<Order> resultList = DbUtil.executeQuery(sql,Order.class);
        return resultList;
    }
}
