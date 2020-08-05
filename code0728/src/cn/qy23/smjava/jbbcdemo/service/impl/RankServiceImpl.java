package cn.qy23.smjava.jbbcdemo.service.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.RankDao;
import cn.qy23.smjava.jbbcdemo.dao.impl.RankDaoImpl;
import cn.qy23.smjava.jbbcdemo.service.RankService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/31 22:03
 */
public class RankServiceImpl implements RankService {
    private RankDao rankDao;

    public RankServiceImpl(RankDao rankDao) {
        this.rankDao = rankDao;
    }

    @Override
    public void rank()  {
        List<Map<String,Object>> resultList = null;
        try {
            resultList = rankDao.rank();
        } catch (KeyNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        for (Map<String,Object> map : resultList){
            System.out.println(map);
        }
    }
}
