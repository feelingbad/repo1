package cn.qy23.smjava.jbbcdemo.view;

import cn.qy23.smjava.jbbcdemo.dao.impl.GoodTypeDaoImpl;
import cn.qy23.smjava.jbbcdemo.entity.GoodType;
import cn.qy23.smjava.jbbcdemo.service.GoodTypeService;
import cn.qy23.smjava.jbbcdemo.service.impl.GoodTypeServiceImpl;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/8/2 22:22
 */
public class GoodTypeCrudTest {
    static Map<Integer, GoodType> map = null;
    static int level = 0;
     GoodTypeService goodTypeService = new GoodTypeServiceImpl(new GoodTypeDaoImpl());
    @Test
    public void readAll() {

        List<GoodType> typeList = goodTypeService.selectAll1();
        for (GoodType goodType : typeList) {
            if (goodType.getPid() == 0) {
                map.put(level, goodType);
                readSon1(goodType.getTid());
            }
        }
        System.out.println(map);
    }

    @Test
    public void readSon1(Integer pid) {
        level++;
        List<GoodType> sonList = goodTypeService.selectSon(pid);
        if (sonList == null) {
            return;
        }
        for (GoodType sonType : sonList) {
            map.put(level,sonType);
            readSon1(sonType.getTid());
        }
    }
}