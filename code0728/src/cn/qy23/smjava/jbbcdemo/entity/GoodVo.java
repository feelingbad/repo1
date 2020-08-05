package cn.qy23.smjava.jbbcdemo.entity;

import java.math.BigDecimal;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/8/1 14:33
 */
public class GoodVo {
    private Good good;
    private int buyNum;
    private BigDecimal bugTotal;


    public GoodVo(Good good, int bugNum, BigDecimal bugTotal) {
        this.good = good;
        this.buyNum = bugNum;
        this.bugTotal = bugTotal;
    }

    public GoodVo(Good good, int bugNum) {
        this.good = good;
        this.buyNum = bugNum;
    }

    public Good getGood() {
        return good;
    }

    public int getBugNum() {
        return buyNum;
    }

    public void setBugNum(int bugNum) {
        this.buyNum = bugNum;
    }

    public BigDecimal getBugTotal() {
        return bugTotal = BigDecimal.valueOf(good.getDiscount()*good.getPrice()*buyNum);
    }

    @Override
    public String toString() {
        return "good=" + good +
                ", bugNum=" + buyNum +
                ", bugTotal=" + bugTotal ;
    }
}
