package cn.qy23.smjava.jbbcdemo.entity;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/27 14:44
 */
public class OrderDetail {
    private Integer deId;
    private Integer deoId;
    private Integer bgId;
    private Integer bgNum;

    public OrderDetail(Integer deId, Integer deoId, Integer bgId, Integer bgNum) {
        this.deId = deId;
        this.deoId = deoId;
        this.bgId = bgId;
        this.bgNum = bgNum;
    }

    public OrderDetail(Integer deoId, Integer bgId, Integer bgNum) {
        this.deoId = deoId;
        this.bgId = bgId;
        this.bgNum = bgNum;
    }


    public Integer getDeId() {
        return deId;
    }

    public void setDeId(Integer deId) {
        this.deId = deId;
    }

    public Integer getDeoId() {
        return deoId;
    }

    public void setDeoId(Integer deoId) {
        this.deoId = deoId;
    }

    public Integer getBgId() {
        return bgId;
    }

    public void setBgId(Integer bgId) {
        this.bgId = bgId;
    }

    public Integer getBgNum() {
        return bgNum;
    }

    public void setBgNum(Integer bgNum) {
        this.bgNum = bgNum;
    }

    @Override
    public String toString() {
        return "deId=" + deId +
                ", deoId=" + deoId +
                ", bgId=" + bgId +
                ", bgNum=" + bgNum;
    }
}

