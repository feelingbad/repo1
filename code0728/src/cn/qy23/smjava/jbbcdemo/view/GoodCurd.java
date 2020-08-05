package cn.qy23.smjava.jbbcdemo.view;

import cn.qy23.smjava.jbbcdemo.dao.GoodDao;
import cn.qy23.smjava.jbbcdemo.dao.impl.GoodDaoImpl;
import cn.qy23.smjava.jbbcdemo.entity.Good;
import cn.qy23.smjava.jbbcdemo.service.GoodService;
import cn.qy23.smjava.jbbcdemo.service.impl.GoodServiceImpl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 11:29
 */
public class GoodCurd implements CurdView{
    private Scanner input = new Scanner(System.in);
    public Good good;
    private GoodService goodService;
    private String choice = "y";

    @Override
    public String getName() {
        return "商品";
    }

    public GoodCurd() {
        GoodDao goodDao = new GoodDaoImpl();
        goodService = new GoodServiceImpl(goodDao);
    }

    public void goodManage() {
       new ChoiceView().choiceView(new GoodCurd());
    }

    @Override
    public void create() {
        int i = 0;
        while (i == 0) {
            good = setInput(0);
            i = goodService.insert(good);
            if (i > 0) {
                System.out.println("添加成功");
                break;
            }
            System.out.println("添加失败，请重新输入");
        }
    }

    @Override
    public void upd() {
        int i = 0;
        while (i == 0) {
            System.out.println("请输入商品ID");
            int gid = input.nextInt();
            good = setInput(gid);
            i = goodService.update(good);
            if (i > 0) {
                System.out.println("更新成功");
                break;
            }
            System.out.println("更新失败，请重新输入  ");
        }
    }


    public void readOne() {
        System.out.println("请输入商品的ID");
        int id = input.nextInt();
        System.out.println(goodService.selectOne(id));
    }

    public void readAll() {
        for (Object good : goodService.selectAll1()) {
            System.out.println(good);
        }
    }

    @Override
    public void read() {
        while ("y".equals(choice)) {
            System.out.println("1.查询商品");
            System.out.println("2.查询所有商品");
            System.out.println("3.退出商品查询");
            switch (input.nextInt()) {
                case 1:
                    readOne();
                    break;
                case 2:
                    readAll();
                    break;
                default:
                    choice = "n";
                    break;
            }
        }
    }

    @Override
    public void del() {
        while ("y".equals(choice)) {
            System.out.println("请输入要删除的商品ID:");
            int id = input.nextInt();
            goodService.delete(id);
            System.out.println("是否继续？(y/n)");
            choice = input.next();
        }
    }

    public Good setInput(int id) {
        System.out.println("请输入商品名称:");
        String goodName = input.next();
        System.out.println("请输入所属类型的ID:");
        int tid = input.nextInt();
        System.out.println("请输入商品数量");
        int goodNum = input.nextInt();
        System.out.println("请输入商品价格");
        float price = input.nextFloat();
        System.out.println("请输入商品状态");
        int state = input.nextInt();
        System.out.println("请输入商品折扣");
        float discount = input.nextFloat();
        Timestamp createTime = Timestamp.from(Instant.now());
        Timestamp changeTime = Timestamp.from(Instant.now());
        good = new Good(1, goodName, tid, goodNum, price, state, discount, createTime, changeTime);
        return good;
    }


}
