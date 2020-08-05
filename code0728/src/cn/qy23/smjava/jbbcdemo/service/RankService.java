package cn.qy23.smjava.jbbcdemo.service;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/31 22:04
 */
public interface RankService {
    /**
     * 排序
     * @throws KeyNotFoundException
     * @throws SQLException
     */
    void rank();
}
