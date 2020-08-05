package cn.qy23.smjava.jbbcdemo.util;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 19:20
 */
public enum  Role {
    /**
     * Admin
     * USER
     */
    Admin("123","admin"),USER("321","user");

    String passWord;
    String name;

    Role(String passWord,String name){
        this.passWord = passWord;
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getName() {
        return name;
    }
}
