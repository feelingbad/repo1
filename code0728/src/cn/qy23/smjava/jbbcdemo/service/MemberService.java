package cn.qy23.smjava.jbbcdemo.service;

import java.math.BigDecimal;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 12:22
 */
public interface MemberService extends CurdService{
    int reChange (BigDecimal credit, Integer id);
}
