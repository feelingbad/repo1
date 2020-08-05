package cn.qy23.smjava.jbbcdemo.entity;

import java.sql.Timestamp;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/28 19:42
 */
public class GoodType {
    private Integer tid;
    private Integer pid;
    private  String typeName;
    private Boolean isOid;
    private Timestamp createTime;
    private Timestamp changeTime;

    public GoodType() {
    }

    public GoodType(Integer tid, Integer pid, String typeName, Boolean isOid, Timestamp createTime, Timestamp changeTime) {
        this.tid = tid;
        this.pid = pid;
        this.typeName = typeName;
        this.isOid = isOid;
        this.createTime = createTime;
        this.changeTime = changeTime;
    }

    public Integer getTid() {
        return tid;
    }

    public Integer getPid() {
        return pid;
    }

    public String getTypeName() {
        return typeName;
    }

    public Boolean getIsOid() {
        return isOid;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    @Override
    public String toString() {
        return
                "商品类型id:" + tid +
                "   父类id:" + pid +
                "   类型名称'" + typeName  +
                "   父类" + isOid +
                "   createTime=" + createTime +
                "   changeTime=" + changeTime
                ;
    }
}
