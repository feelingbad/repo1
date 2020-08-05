package cn.qy23.smjava.jbbcdemo.entity;

import java.sql.Timestamp;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/28 23:00
 */
public class Good{
    private Integer gid;
    private  String goodName;
    private Integer tid;
    private Integer goodNum;
    private Float price;
    private Integer state;
    private Float discount;
    private Timestamp createTime;
    private Timestamp changeTime;

    public Good(Integer gid, String goodName, Integer tid, Integer goodNum, Float price, Integer state, Float discount, Timestamp createTime, Timestamp changeTime) {
        this.gid = gid;
        this.goodName = goodName;
        this.tid = tid;
        this.goodNum = goodNum;
        this.price = price;
        this.state = state;
        this.discount = discount;
        this.createTime = createTime;
        this.changeTime = changeTime;
    }

    public Good() {
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }

    @Override
    public String toString() {
        return
                "gid=" + gid +
                ", goodName='" + goodName +
                ", tid=" + tid +
                ", goodNum=" + goodNum +
                ", price=" + price +
                ", state=" + state +
                ", discount=" + discount +
                ", createTime=" + createTime +
                ", changeTime=" + changeTime
                ;
    }
}
