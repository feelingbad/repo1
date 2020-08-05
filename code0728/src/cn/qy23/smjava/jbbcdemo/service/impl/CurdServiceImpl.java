package cn.qy23.smjava.jbbcdemo.service.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.BaseDao;

import cn.qy23.smjava.jbbcdemo.service.CurdService;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 9:26
 */
public class CurdServiceImpl<T> implements CurdService<T> {
    private BaseDao baseDao;

    public CurdServiceImpl(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int insert(T t) {
        int num = 0;
        if (t != null) {
            try {
                num = baseDao.insert(t);
            }catch (InputMismatchException ie){
                System.out.println("输入格式错误");
            } catch (MySQLIntegrityConstraintViolationException me){
                System.out.println("添加重复信息");
            }catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("goodType is null!");
        }
        return num;
    }

    @Override
    public int delete(int id) {
        int num = 0;
        try {
            num = baseDao.delete(id);
        } catch (KeyNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int update(T t) {
        int num = 0;
        if (t != null) {
            try {
                num = baseDao.update(t);
            } catch (KeyNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("goodType is null!");
        }
        return num;
    }

    @Override
    public T selectOne(int id) {
        T resultList = null;
        try {
            resultList = (T) baseDao.selectOne(id);
        } catch (KeyNotFoundException | SQLException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultList;
    }


//    @Override
//    public List<Map<String, Object>> selectAll() {
//        List<Map<String, Object>> resultList = null;
//        try {
//            resultList = baseDao.selectAll();
//        } catch (KeyNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return resultList;
//    }

    @Override
    public List<T> selectAll1() {
        List<T> resultList = null;
        try {
            resultList = baseDao.selectAll1();
        } catch (KeyNotFoundException | SQLException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}

