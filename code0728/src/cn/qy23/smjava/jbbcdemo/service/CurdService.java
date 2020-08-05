package cn.qy23.smjava.jbbcdemo.service;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 9:26
 */
public interface CurdService<T> {
    /**
     *添加信息
     * @param t
     * @return int
     */
    int insert(T t) ;

    /**
     * 删除信息
     * @param id sql语句中where xx = id
     * @return int
     */
    int delete(int id) ;

    /**
     * 更新信息
     * @param t entity
     * @return int
     */
    int update(T t) ;

    /**
     * 查询某条信息
     * @param id
     * @return T
     */
    T selectOne(int id) ;

//    /**
//     * 查询所有信息
//     * @return List<Map<String, Object>>
//     *
//     */
//    List<Map<String, Object>> selectAll() ;

    /**用entity来接受
     * 查询所有信息
     * @return List<T>
     */
    List<T> selectAll1() ;

}
