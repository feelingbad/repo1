package cn.qy23.smjava.jbbcdemo.view;


import cn.qy23.smjava.jbbcdemo.dao.GoodTypeDao;
import cn.qy23.smjava.jbbcdemo.dao.impl.GoodTypeDaoImpl;
import cn.qy23.smjava.jbbcdemo.entity.GoodType;
import cn.qy23.smjava.jbbcdemo.service.GoodTypeService;
import cn.qy23.smjava.jbbcdemo.service.impl.GoodTypeServiceImpl;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/29 20:49
 */

public class GoodTypeCrud implements CurdView {
    private Scanner input = new Scanner(System.in);
    private GoodTypeService goodTypeService;
    private String choice = "y";

    GoodTypeCrud() {
        GoodTypeDao goodTypeDao = new GoodTypeDaoImpl();
        goodTypeService = new GoodTypeServiceImpl(goodTypeDao);
    }

    @Override
    public String getName() {
        return "商品类型";
    }

    void goodTypeManage() {
        new ChoiceView().choiceView(new GoodTypeCrud());
    }

    @Override
    public void upd() {
        int i = 0;
        while (i == 0) {
            System.out.println("请输入商品类型ID:");
            int tid = input.nextInt();
            GoodType goodType = setInput(tid);
            i = goodTypeService.update(goodType);
            if (i > 0) {
                System.out.println("更新成功");
            }
            System.out.println("更新失败，请重新输入");
        }
    }

    @Override
    public void create() {
        int i = 0;
        while (i == 0) {
            GoodType goodType = setInput(0);
            i = goodTypeService.insert(goodType);
            if (i > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败，请重新输入");
            }
        }
    }

    @Override
    public void del() {
        int i = 0;
        while (i == 0) {
            System.out.println("请输入要删除的商品类型ID:");
            int id = input.nextInt();
            i = goodTypeService.delete(id);
            if (i > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败，请重新输入");
            }
        }
    }

    @Override
    public void read() {
        while ("y".equals(choice)) {
            System.out.println("1.查询商品类型");
            System.out.println("2.查询父类商品的子类商品类型");
            System.out.println("3.查询所有商品类型");
            System.out.println("4.退出查询");
            switch (input.nextInt()) {
                case 1:
                    readOne();
                    break;
                case 2:
                    readSon();
                    break;
                case 3:
                    readAll();
                    break;
                default:
                    choice = "n";
                    break;
            }
        }
    }

    private GoodType setInput(int tid) {
        System.out.println("请输入父类的ID:");
        int pid = input.nextInt();
        System.out.println("请输入商品名称:");
        String typeName = input.next();
        System.out.println("是否为父类:");
        boolean isOid = false;
        while (input.hasNextBoolean()) {
             isOid = input.nextBoolean();
        }
        Timestamp createTime = Timestamp.from(Instant.now());
        Timestamp changeTime = Timestamp.from(Instant.now());
        return new GoodType(tid, pid, typeName, isOid, createTime, changeTime);
    }


    private void readOne() {
        System.out.println("请输入商品类型的ID");
        int id = input.nextInt();
        System.out.println(goodTypeService.selectOne(id));
    }

    private void readAll() {
        String level = "";
        List<GoodType> typeList = goodTypeService.selectAll1();
        for (GoodType goodType : typeList) {
            if (goodType.getPid() == 0) {
                System.out.print(level);
                System.out.println(goodType);
                readSon1(goodType.getTid(), level);
            }
        }
    }

    private void readSon1(int pid, String level) {
        level += "--|";
        List<GoodType> sonList = goodTypeService.selectSon(pid);
        if (sonList == null) {
            return;
        }
        for (GoodType sonType : sonList) {
            System.out.print(level);
            System.out.println(sonType);
            readSon1(sonType.getTid(), level);
        }
    }

    private void readSon() {
        System.out.println("请输入要查询的父类商品ID");
        int id = input.nextInt();
        for (Object goodType : goodTypeService.selectSon(id)) {
            System.out.println(goodType);
        }
    }
}