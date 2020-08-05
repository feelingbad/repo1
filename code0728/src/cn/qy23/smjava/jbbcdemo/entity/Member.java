package cn.qy23.smjava.jbbcdemo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 11:03
 */
public class Member {
    private Integer mid;
    private String mName;
    private String password;
    private String phone;
    private BigDecimal balance;
    private Float score;
    private Timestamp createTime;
    private Timestamp changeTime;

    public Member(Integer mid, String mName, String password, String phone,  Float score,BigDecimal balance, Timestamp createTime, Timestamp changeTime) {
        this.mid = mid;
        this.mName = mName;
        this.password = password;
        this.phone = phone;
        this.score = score;
        this.balance = balance;
        this.createTime = createTime;
        this.changeTime = changeTime;
    }

    public Integer getMid() {
        return mid;
    }


    public String getmName() {
        return mName;
    }


    public String getPassword() {
        return password;
    }


    public String getPhone() {
        return phone;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
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
                "会员编号:" + mid +
                "\t会员名字:" + mName +
                "\t会员密码:" + password +
                "\t联系电话:" + phone +
                "\t余额:" + balance +
                "\t会员积分:" + score +
                "\tcreateTime:" + createTime +
                "\tchangeTime;" + changeTime;
    }
}
