package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.BaseDao;
import cn.qy23.smjava.jbbcdemo.dao.GoodDao;
import cn.qy23.smjava.jbbcdemo.entity.Good;
import cn.qy23.smjava.jbbcdemo.entity.GoodType;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/28 23:07
 */
public class GoodDaoImpl implements GoodDao {
    @Override
    public int insert(Good good) throws KeyNotFoundException, SQLException {
        String goodName = good.getGoodName();
        int tid = good.getTid();
        int goodNum = good.getGoodNum();
        float price = good.getPrice();
        int state = good.getState();
        float discount = good.getDiscount();
        Timestamp createTime = good.getCreateTime();
        Timestamp changeTime = good.getChangeTime();
        String sql = "INSERT INTO good (gname,tid,gnum,price,state,discount,createtime,changetime) values (?,?,?,?,?,?,?,?)";
        int i = DbUtil.executeUpdate(sql,goodName,tid,goodNum,price,state,discount,createTime,changeTime);
        return i;
    }

    @Override
    public int delete(Integer id) throws KeyNotFoundException, SQLException {
        String sql = "UPDATE good SET state= 3 WHERE gid = ?";
        int i = DbUtil.executeUpdate(sql,id);
        return i;
    }

    @Override
    public int update(Good good) throws KeyNotFoundException, SQLException {
        int gid = good.getGid();
        String goodName = good.getGoodName();
        int tid = good.getTid();
        int goodNum = good.getGoodNum();
        float price = good.getPrice();
        int state = good.getState();
        float discount = good.getDiscount();
        Timestamp createTime = good.getCreateTime();
        Timestamp changeTime = good.getChangeTime();
        String sql = "UPDATE good SET gname = ?,tid= ?,gnum=?,price=?,state=?,discount=?,createtime=?,changetime=? WHERE gid = ?";
        int i = DbUtil.executeUpdate(sql,goodName,tid,goodNum,price,state,discount,createTime,changeTime,gid);
        return i;
    }

    @Override
    public Good selectOne(Integer id) throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM good WHERE gid =?";
        List<Good> resultList = DbUtil.executeQuery(sql,Good.class,id);
        if (resultList.size() ==0) {
            return null;
        }
        return resultList.get(0);
    }
//    @Override
//    public Map<String, Object> selectName(String goodName) throws KeyNotFoundException, SQLException {
//        String sql = "SELECT * FROM good WHERE gname =?";
//        List<Map<String, Object>> resultList = DbUtil.executeQuery(sql,goodName);
//        return resultList.get(0);
//    }

//    @Override
//    public List<Map<String, Object>> selectAll() throws KeyNotFoundException, SQLException {
//        String sql = "SELECT * FROM good";
//        return DbUtil.executeQuery(sql);
//    }

    @Override
    public List<Good> selectAll1() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM good";
        return DbUtil.executeQuery(sql,Good.class);
    }
}
