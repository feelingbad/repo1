package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.BaseDao;
import cn.qy23.smjava.jbbcdemo.dao.GoodTypeDao;
import cn.qy23.smjava.jbbcdemo.entity.GoodType;
import cn.qy23.smjava.jbbcdemo.entity.OrderDetail;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/28 19:40
 */
public class GoodTypeDaoImpl implements GoodTypeDao {


    @Override
    public int insert(GoodType goodType) throws KeyNotFoundException, SQLException {
        Integer pid = goodType.getPid();
        String typeName = goodType.getTypeName();
        Boolean isOid = goodType.getIsOid();
        Timestamp createTime = goodType.getCreateTime();
        Timestamp changeTime = goodType.getChangeTime();
        String sql = "INSERT INTO good_type (pid,tname,is_oid,createtime,changetime) VALUES (?,?,?,?,?) ";
        int i = DbUtil.executeUpdate(sql, pid, typeName, isOid, createTime, changeTime);
        return i;
    }

    @Override
    public int delete(Integer id) throws KeyNotFoundException, SQLException {
        String sql = "DELETE FROM good_type WHERE tid = ?";
        int i = DbUtil.executeUpdate(sql,id);
        return i;
    }

    @Override
    public int update(GoodType goodType) throws KeyNotFoundException, SQLException {
        Integer tid = goodType.getTid();
        Integer pid = goodType.getPid();
        String typeName = goodType.getTypeName();
        boolean isOid = goodType.getIsOid();
        Timestamp createTime = goodType.getCreateTime();
        Timestamp changeTime = goodType.getChangeTime();
        String sql = "UPDATE good_type SET pid=?,tname=?,is_oid=?,createtime=?,changetime= ? WHERE tid = ?;";
        int i = DbUtil.executeUpdate(sql,pid,typeName,isOid,createTime,changeTime,tid);
        return i;
    }

    @Override
    public GoodType selectOne(Integer id) throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM good_type WHERE tid = ?";
        List<GoodType> resultList = DbUtil.executeQuery(sql,GoodType.class,id);
        if (resultList.size() ==0) {
            return null;
        }
        return resultList.get(0);
    }

//    @Override
//    public List<Map<String, Object>> selectAll() throws KeyNotFoundException, SQLException {
//        String sql = "SELECT * FROM good_type";
//        List<Map<String ,Object>> resultList = DbUtil.executeQuery(sql);
//        return resultList;
//    }

    @Override
    public List<GoodType> selectAll1() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM good_type";
        List<GoodType> resultList = DbUtil.executeQuery(sql,GoodType.class);
        return resultList;
    }

    @Override
    public List<GoodType> selectSon(Integer pid) throws Exception {
        String sql = "Select * from good_type where pid = ? ";
        List<GoodType> resultList = DbUtil.executeQuery(sql,GoodType.class,pid);
        return resultList;
    }
}
