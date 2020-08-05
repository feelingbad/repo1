package cn.qy23.smjava.jbbcdemo.view;


import cn.qy23.smjava.jbbcdemo.dao.impl.RankDaoImpl;
import cn.qy23.smjava.jbbcdemo.service.impl.RankServiceImpl;
import cn.qy23.smjava.jbbcdemo.util.ConfirmPassword;


import java.util.Scanner;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 19:13
 */

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 19:13
 */
public class SuperMarketManage {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = "y";
        while ("y".equals(choice)) {
            System.out.println("-----------超市管理系统-----------");
            System.out.println("----------1.管理员登录------------");
            System.out.println("----------2.收银员登录------------");
            System.out.println("----------3.退出登录--------------");
            //选择登录界面
            int c = input.nextInt();
            if (c == 1) {
                adminManage();
            } else if (c == 2) {
                userManage();
            } else {
                choice = "n";
            }
        }
    }

    /**
     * 管理员对商品类型，商品，会员进行管理
     *
     * @return
     */
    public static void adminManage() {
        String choice = "y";
        System.out.print("user: " );
        String name = input.next();
        System.out.print("password: ");
        String password = input.next();
        if (ConfirmPassword.confirmAdmin(password,name)) {
            while ("y".equals(choice)) {
                System.out.println("-----------1.商品类型管理-----------");
                System.out.println("-------------2.商品管理-------------");
                System.out.println("-------------3.会员管理-------------");
                System.out.println("-------------4.退出管理-------------");
                switch (input.nextInt()) {
                    case 1:
                        new GoodTypeCrud().goodTypeManage();
                        break;
                    case 2:
                        new GoodCurd().goodManage();
                        break;
                    case 3:
                        new MemberCurd().memberManage();
                        break;
                    default:
                        choice = "n";
                        break;
                }
            }
        } else {
            System.out.println("密码错误");
        }
    }

    /**
     * 收银员对购买管理，订单查询，排行统计进行操作
     *
     * @return
     */
    public static void userManage() {
        String choice = "y";
        System.out.println("user: " );
        String name = input.next();
        System.out.print("password: ");
        String password = input.next();
        if (ConfirmPassword.confirmUser(password,name)) {
            while ("y".equals(choice)) {
                System.out.println("-------------1.购买管理-------------");
                System.out.println("-------------2.订单查询-------------");
                System.out.println("-------------3.排行查询-------------");
                System.out.println("-------------4.退出管理-------------");
                switch (input.nextInt()) {
                    case 1:
                        new BuyCurd().bugManager();
                        break;
                    case 2:
                        new OrderQuery().orderQuery();
                        break;
                    case 3:
                        rank();
                        break;
                    default:
                        choice = "n";
                        break;
                }
            }
        } else {
            System.out.println("密码错误");
        }
    }

    public static void rank() {
        new RankServiceImpl(new RankDaoImpl()).rank();
    }

}
