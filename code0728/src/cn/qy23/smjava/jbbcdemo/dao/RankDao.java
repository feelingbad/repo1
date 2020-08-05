package cn.qy23.smjava.jbbcdemo.dao;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/31 21:50
 */
public interface RankDao {
    /**
     *要求按月份及按商品类别统计销量前10的商品及总销量
     * @return
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    List<Map<String, Object>> rank() throws KeyNotFoundException, SQLException;
}
