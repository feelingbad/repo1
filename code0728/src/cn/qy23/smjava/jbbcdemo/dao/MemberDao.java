package cn.qy23.smjava.jbbcdemo.dao;



import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.entity.Member;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 11:07
 */
public interface MemberDao extends BaseDao<Member>{
    /**
     *
     * @param credit 金额
     * @param id 会员id
     * @return 是否修改成功
     * */
    int reChange (BigDecimal credit, Integer id) throws KeyNotFoundException, SQLException;
}
