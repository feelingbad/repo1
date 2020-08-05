package cn.qy23.smjava.jbbcdemo.dao.impl;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.RankDao;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/31 21:52
 */
public class RankDaoImpl implements RankDao {


    @Override
    public List<Map<String, Object>> rank() throws KeyNotFoundException, SQLException {
        String sql = "SELECT month(b.order_time) as 月份, c.tid as 商品类型 ,\n" +
                "a.bgid as 商品id,sum(a.bgnum) as 销售量,c.gname as 商品名称 \n" +
                "FROM tb_order_detail a\n" +
                "JOIN t_order b\n" +
                "ON a.deoid = b.oid \n" +
                "left JOIN good c \n" +
                "ON  c.gid = a.bgid\n" +
                "GROUP BY 月份,商品类型,商品id\n" +
                "ORDER BY 月份,商品类型,销售量 DESC\n" +
                "LIMIT 0,10;";
        return DbUtil.executeQuery(sql);
    }
}
