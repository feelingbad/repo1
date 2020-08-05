package cn.qy23.smjava.jbbcdemo.service.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.GoodTypeDao;
import cn.qy23.smjava.jbbcdemo.entity.GoodType;
import cn.qy23.smjava.jbbcdemo.service.GoodTypeService;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 17:23
 */
public class GoodTypeServiceImpl extends CurdServiceImpl implements GoodTypeService {
    private GoodTypeDao goodTypeDao;

    public GoodTypeServiceImpl(GoodTypeDao goodTypeDao) {
        super(goodTypeDao);
        this.goodTypeDao = goodTypeDao;
    }

    @Override
    public List<GoodType> selectSon(Integer pid) {
        List<GoodType> resultList = null;
        try {
            resultList = goodTypeDao.selectSon(pid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
