package cn.qy23.smjava.jbbcdemo.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 9:30
 */
public class Order {
    private Integer orderId;
    private Integer userId;
    private BigDecimal orderAmount;
    private Timestamp orderTime;
    private Integer payType;

    public Order(Integer orderId, Integer userId, BigDecimal orderAmount, Timestamp orderTime, Integer payType) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderAmount = orderAmount;
        this.orderTime = orderTime;
        this.payType = payType;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public Integer getPayType() {
        return payType;
    }

    @Override
    public String toString() {
        return "orderId=" + orderId +
                ", userId=" + userId +
                ", orderAmount=" + orderAmount +
                ", orderTime=" + orderTime +
                ", payType=" + payType ;
    }
}
