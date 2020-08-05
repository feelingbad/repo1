package cn.qy23.smjava.jbbcdemo.dao;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.Good;


import java.sql.SQLException;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 9:42
 */
public interface GoodDao extends BaseDao<Good>{
//    /**
//     * 通过名字进行查询
//     * @param goodName
//     * @return
//     * @throws KeyNotFoundException
//     * @throws SQLException
//     */
//    Map<String, Object> selectName(String goodName) throws KeyNotFoundException, SQLException;
}
