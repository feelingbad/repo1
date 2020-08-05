package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.Member;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.Assert.*;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 11:34
 */
public class MemberDaoImplTest {

    @Test
    public void reChange() throws KeyNotFoundException, SQLException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        System.out.println(memberDao.reChange(BigDecimal.valueOf(900), 1));
    }

    @Test
    public void insert() throws KeyNotFoundException, SQLException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        Member member = new Member(1,"CoCo","123456","1235456", 99.5F,BigDecimal.valueOf(98.1F), Timestamp.from(Instant.now()),Timestamp.from(Instant.now()));
        System.out.println(memberDao.insert(member));
    }

    @Test
    public void delete() throws KeyNotFoundException, SQLException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        System.out.println(memberDao.delete(2));
    }

    @Test
    public void update() throws KeyNotFoundException, SQLException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        Member member = new Member(1,"zero","123456","1235456",  99.5F,BigDecimal.valueOf(98.1F),Timestamp.from(Instant.now()),Timestamp.from(Instant.now()));
        System.out.println(memberDao.update(member));
    }

    @Test
    public void selectOne() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        System.out.println(memberDao.selectOne(1));
    }


    @Test
    public void selectAll1() throws KeyNotFoundException, SQLException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        MemberDaoImpl memberDao = new MemberDaoImpl();
        System.out.println(memberDao.selectAll1());
    }
}