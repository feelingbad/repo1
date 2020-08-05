package cn.qy23.smjava.jbbcdemo.view;

import java.util.Scanner;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/8/3 10:59
 */
public class ChoiceView{
    private String c ;
    private Scanner input ;

    ChoiceView() {
        this.c = "y";
        this.input= new Scanner(System.in);
    }

    public void choiceView(CurdView curd) {
        while ("y".equals(c)) {
            System.out.println("----------1.添加"+curd.getName()+"信息----------");
            System.out.println("----------2.删除"+curd.getName()+"信息----------");
            System.out.println("----------3.修改"+curd.getName()+"信息----------");
            System.out.println("----------4.查询"+curd.getName()+"信息----------");
            System.out.println("----------5.退出----------------------");
            int i = input.nextInt();
            switch (i) {
                case 1:
                    curd.create();
                    c = "y";
                    break;
                case 2:
                    curd.del();
                    c = "y";
                    break;
                case 3:
                    curd.upd();
                    c = "y";
                    break;
                case 4:
                    curd.read();
                    c = "y";
                    break;
                default:
                    c = "n";
                    break;
            }
        }
    }
}
