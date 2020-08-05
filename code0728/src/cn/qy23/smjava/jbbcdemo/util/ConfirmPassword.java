package cn.qy23.smjava.jbbcdemo.util;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 19:43
 */
public class ConfirmPassword {
    public static boolean confirmAdmin(String password ,String name){
        if (password.equals(Role.Admin.getPassWord())&& name.equals(Role.Admin.getName())) {
            return true;
        }
        return false;
    }
    public static boolean confirmUser(String password,String name){
        if (password.equals(Role.USER.getPassWord())&& name.equals(Role.USER.getName())) {
            return true;
        }
        return false;
    }
}
