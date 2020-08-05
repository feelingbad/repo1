package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.BaseDao;
import cn.qy23.smjava.jbbcdemo.dao.OrderDetailDao;
import cn.qy23.smjava.jbbcdemo.entity.Order;
import cn.qy23.smjava.jbbcdemo.entity.OrderDetail;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/27 14:43
 */
public class OrderDetailDaoImpl implements OrderDetailDao {

    @Override
    public int insert(OrderDetail orderDetail) throws KeyNotFoundException, SQLException {
        Integer deoId = orderDetail.getDeoId();
        Integer bgId = orderDetail.getBgId();
        Integer bgNum = orderDetail.getBgNum();
        String sql = "INSERT INTO tb_order_detail(deoid,bgid,bgnum) VALUES(?,?,?)";
        int i = DbUtil.executeUpdate(sql, deoId,bgId,bgNum);
        return i;
    }

    @Override
    public int delete(Integer id) throws KeyNotFoundException, SQLException {
        String sql = "DELETE FROM tb_order_detail WHERE deid = ?";
        int i = DbUtil.executeUpdate(sql,id);
        return i;
    }

    @Override
    public int update(OrderDetail orderDetail) throws KeyNotFoundException, SQLException {
        String sql = "UPDATE tb_order_detail SET deid=?, deoid=?, bgid=?, bgnum=? Where deid=?";
        int i = DbUtil.executeUpdate(sql,orderDetail.getDeId(),orderDetail.getDeoId(),orderDetail.getBgId(),orderDetail.getBgNum(),orderDetail.getDeId());
        return i;
    }

    @Override
    public OrderDetail selectOne(Integer id) throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM tb_order_detail WHERE bgid =?";
        List<OrderDetail> resultList = DbUtil.executeQuery(sql,OrderDetail.class,id);
        if (resultList.size() ==0) {
            return null;
        }
        return resultList.get(0);
    }


//    @Override
//    public List<Map<String, Object>> selectAll() throws KeyNotFoundException, SQLException {
//        String sql = "SELECT * FROM tb_order_detail";
//        List<Map<String,Object>> resultList = DbUtil.executeQuery(sql);
//        return resultList;
//    }

    @Override
    public List<OrderDetail> selectAll1() throws NoSuchMethodException, KeyNotFoundException, IllegalAccessException, InstantiationException, SQLException, InvocationTargetException, ClassNotFoundException {
        String sql = "SELECT * FROM tb_order_detail";
        List<OrderDetail> resultList = DbUtil.executeQuery(sql,OrderDetail.class);
        return resultList;
    }

    @Override
    public int insertMore(List<OrderDetail> orderDetailList) throws ClassNotFoundException, KeyNotFoundException, SQLException {
       StringBuffer sb = new StringBuffer();
       sb.append("INSERT INTO tb_order_detail (deoid,bgid,bgnum) VALUES ");
       int size = orderDetailList.size();
       int fieldLen = OrderDetail.class.getDeclaredFields().length-1;
       int len = size* fieldLen;
       Object[] objects = new Object[len];
       OrderDetail orderDetail = null;
        for (int i = 0; i < size; i++) {
            sb.append("(?,?,?),");
            orderDetail = orderDetailList.get(i);
            objects[i*fieldLen] = orderDetail.getDeoId();
            objects[i*fieldLen+1] = orderDetail.getBgId();
            objects[i*fieldLen+2] = orderDetail.getBgNum();
        }
        CharSequence sqlSequence = sb.subSequence(0,sb.lastIndexOf(","));
        int i = DbUtil.executeUpdate(sqlSequence.toString(),objects);
        return i;
    }
}
