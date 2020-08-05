package cn.qy23.smjava.jbbcdemo.view;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/8/3 11:02
 */
public interface CurdView {
    /**
     * 增加记录
     */
    void create();

    /**
     * 删除记录
     */
    void del();

    /**
     * 修改记录
     */
    void upd();

    /**
     * 查询记录
     */
    void read();

    /**
     * 得到名字
     * @return name
     */
    String getName();

}
