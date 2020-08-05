package cn.qy23.smjava.jbbcdemo.service.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.GoodDao;
import cn.qy23.smjava.jbbcdemo.service.GoodService;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 10:14
 */
public class GoodServiceImpl extends CurdServiceImpl implements GoodService {

    public GoodServiceImpl(GoodDao goodDao) {
        super(goodDao);
    }

}
