package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.MemberDao;
import cn.qy23.smjava.jbbcdemo.entity.Member;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;
import cn.qy23.smjava.jbbcdemo.util.Encipher;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 11:09
 */
public class MemberDaoImpl implements MemberDao {

    @Override
    public int reChange(BigDecimal credit,Integer id) throws KeyNotFoundException, SQLException {
        String sql = "UPDATE member SET balance = balance+? WHERE mid = ? ";
        int i = DbUtil.executeUpdate(sql,credit,id);
        return i;
    }

    @Override
    public int insert(Member member) throws KeyNotFoundException, SQLException {
        String mName = member.getmName();
        String password = member.getPassword();
        String phone = member.getPhone();
        BigDecimal balance = member.getBalance();
        float score = member.getScore();
        Timestamp createTime = member.getCreateTime();
        Timestamp changeTime = member.getChangeTime();
        String sql = "INSERT INTO member (mname,pw,phone,score,balance,createtime,changetime) values (?,?,?,?,?,?,?)";
        int i = DbUtil.executeUpdate(sql,mName,password,phone,balance,score,createTime,changeTime);
        return i;
    }

    @Override
    public int delete(Integer id) throws KeyNotFoundException, SQLException {
        String sql = "DELETE FROM member WHERE mid = ?";
        int i = DbUtil.executeUpdate(sql,id);
        return i;
    }

    @Override
    public int update(Member member) throws KeyNotFoundException, SQLException {
        int mid = member.getMid();
        String mName = member.getmName();
        String password = Encipher.getResult(member.getPassword());
        String phone = member.getPhone();
        BigDecimal balance = member.getBalance();
        float score = member.getScore();
        Timestamp createTime = member.getCreateTime();
        Timestamp changeTime = member.getChangeTime();
        String sql = "UPDATE member SET mname = ?,pw = ?,phone = ?,score = ?,balance = ?,createtime = ?,changetime = ? WHERE mid =?";
        int i = DbUtil.executeUpdate(sql,mName,password,phone,balance,score,createTime,changeTime,mid);
        return i;
    }

    @Override
    public Member selectOne(Integer id) throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM member WHERE mid =?";
        List<Member> resultList = DbUtil.executeQuery(sql,Member.class,id);
        if (resultList.size() ==0) {
            return null;
        }
        return resultList.get(0);
    }

//    @Override
//    public List<Map<String, Object>> selectAll() throws KeyNotFoundException, SQLException {
//        String sql = "SELECT * FROM member ";
//        List<Map<String,Object>> resultList = DbUtil.executeQuery(sql);
//        return resultList;
//    }

    @Override
    public List<Member> selectAll1() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String sql = "SELECT * FROM member ";
        List<Member> resultList = DbUtil.executeQuery(sql,Member.class);
        return resultList;
    }
}
