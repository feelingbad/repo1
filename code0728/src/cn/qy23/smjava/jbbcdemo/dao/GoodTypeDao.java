package cn.qy23.smjava.jbbcdemo.dao;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.GoodType;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 15:06
 */
public interface GoodTypeDao extends BaseDao<GoodType>{
    /**
     * 查询父类型下所有的子类型
     * @param pid
     * @return
     */
    List<GoodType> selectSon(Integer pid) throws Exception;
}
