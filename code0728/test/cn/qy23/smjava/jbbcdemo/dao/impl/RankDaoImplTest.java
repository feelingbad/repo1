package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.RankDao;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/31 21:56
 */
public class RankDaoImplTest {

    @Test
    public void rank()  {
        RankDao rankDao = new RankDaoImpl();
        List<Map<String,Object>> resultList = null;
        try {
            resultList = rankDao.rank();
        } catch (KeyNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Map<String,Object> map : resultList){
            System.out.println(map);
        }
    }

    @Test
    public void testRank() {
        rank();
    }
}