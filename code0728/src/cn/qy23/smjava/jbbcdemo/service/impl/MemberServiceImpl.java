package cn.qy23.smjava.jbbcdemo.service.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.MemberDao;
import cn.qy23.smjava.jbbcdemo.service.MemberService;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 11:59
 */
public class MemberServiceImpl extends CurdServiceImpl implements MemberService {
    private MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        super(memberDao);
        this.memberDao = memberDao;
    }

    @Override
    public int reChange(BigDecimal credit, Integer id) {

        int num = 0;
        try {
            num = memberDao.reChange(credit,id);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return num;
    }

}
