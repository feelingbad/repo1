package cn.qy23.smjava.jbbcdemo.view;

import cn.qy23.smjava.jbbcdemo.common.KeyNotFoundException;
import cn.qy23.smjava.jbbcdemo.dao.GoodDao;
import cn.qy23.smjava.jbbcdemo.dao.MemberDao;
import cn.qy23.smjava.jbbcdemo.dao.OrderDao;
import cn.qy23.smjava.jbbcdemo.dao.OrderDetailDao;
import cn.qy23.smjava.jbbcdemo.dao.impl.GoodDaoImpl;
import cn.qy23.smjava.jbbcdemo.dao.impl.MemberDaoImpl;
import cn.qy23.smjava.jbbcdemo.dao.impl.OrderDetailDaoImpl;
import cn.qy23.smjava.jbbcdemo.dao.impl.OrderImpl;
import cn.qy23.smjava.jbbcdemo.entity.*;
import cn.qy23.smjava.jbbcdemo.service.GoodService;
import cn.qy23.smjava.jbbcdemo.service.MemberService;
import cn.qy23.smjava.jbbcdemo.service.OrderDetailService;
import cn.qy23.smjava.jbbcdemo.service.OrderService;
import cn.qy23.smjava.jbbcdemo.service.impl.GoodServiceImpl;
import cn.qy23.smjava.jbbcdemo.service.impl.MemberServiceImpl;
import cn.qy23.smjava.jbbcdemo.service.impl.OrderDetailServiceImpl;
import cn.qy23.smjava.jbbcdemo.service.impl.OrderServiceImpl;
import cn.qy23.smjava.jbbcdemo.util.DbUtil;
import cn.qy23.smjava.jbbcdemo.util.Encipher;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 15:16
 */
public class BuyCurd {
    public Scanner input ;
    public Member member;
    public MemberService memberService;
    public GoodService goodService;
    public OrderService orderService;
    public OrderDetailService orderDetailService;
    public String choice = "y";
    public Integer payType;

    public BuyCurd() {
        OrderDao orderDao = new OrderImpl();
        orderService = new OrderServiceImpl(orderDao);
        OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
        orderDetailService = new OrderDetailServiceImpl(orderDetailDao);
        MemberDao memberDao = new MemberDaoImpl();
        memberService = new MemberServiceImpl(memberDao);
        GoodDao goodDao = new GoodDaoImpl();
        goodService = new GoodServiceImpl(goodDao);
        input = new Scanner(System.in);
    }

    public void bugManager() {
        while ("y".equals(choice)) {
            System.out.println("1.添加商品");
            System.out.println("2.修改商品数量");
            System.out.println("3.删除商品");
            System.out.println("4.展示购物车");
            System.out.println("5.确定购买:");
            System.out.println("6.退出购物车:");
            int i = input.nextInt();
            switch (i) {
                case 1:
                    create();
                    break;
                case 2:
                    upd();
                    choice = "y";
                    break;
                case 3:
                    del();
                    choice = "y";
                    break;
                case 4:
                    readAll();
                    System.out.println("按任意键退出");
                    choice = input.next();
                    choice = "y";
                    break;
                case 5:
                    settleMoney();
                    choice = "y";
                    break;
                default:
                    choice = "n";
                    break;
            }
        }
    }

    public void create() {
        System.out.println("所有商品详情:");
        List<Good> goods = goodService.selectAll1();
        for (Good good : goods) {
            if (good.getState() == 1) {
                System.out.println(good);
            }
        }

        //判断商品ID是否能否购买
        System.out.println("输入商品ID:");
        int buyId = input.nextInt();
        Good good = null;
        good = (Good) goodService.selectOne(buyId);

        //商品是否购买过
        GoodVo goodVo = Cart.isBuy(buyId);

        //购物车添加商品
        if (good != null && good.getState() == 1 && good.getGoodNum() > 0) {
            System.out.println(good);
            int buyNum = 0;
            while (true) {
                System.out.println("请输入购买数量:");
                buyNum = input.nextInt();
                if (buyNum >= 0) {
                    if (goodVo != null) {
                        if (goodVo.getBugNum() + buyNum > good.getGoodNum()) {
                            System.out.println("库存不足，重新输入数量");
                        } else {
                            buyNum += goodVo.getBugNum();
                            break;
                        }
                    } else {
                        if (buyNum > good.getGoodNum()) {
                            System.out.println("库存不足，重新输入数量");
                        } else {
                            break;
                        }
                    }
                } else {
                    System.out.println("数量要大于0");
                }
            }
            Cart.add(good, buyNum);
            System.out.println("添加成功");
        } else {
            System.out.println("您添加的商品无法购买");
        }
    }

    public void upd() {
        if (Cart.getBuySum().compareTo(BigDecimal.ZERO) > 0) {
            while (true) {
                readAll();
                System.out.println("输入需要更新的商品ID");
                int updId = input.nextInt();
                //判断是否有该商品
                GoodVo goodVo = Cart.isBuy(updId);
                //更新商品
                if (goodVo != null) {
                    System.out.println("重新设置购买数量");
                    int buyNum = input.nextInt();
                    if (Cart.upd(goodVo, buyNum)) {

                        System.out.println("更改成功");
                        break;
                    } else {
                        System.out.println("库存不足");
                    }
                } else {
                    System.out.println("您的购物车没有该商品");
                }
            }
        } else {
            System.out.println("您的购物车是空的");
        }
    }

    public void del() {
        if (Cart.getBuySum().compareTo(BigDecimal.ZERO) > 0) {
            while (true) {
                readAll();
                System.out.println("输入需要删除的商品ID");
                int delId = input.nextInt();
                //判断是否有该商品
                GoodVo goodVo = Cart.isBuy(delId);
                //删除商品
                if (goodVo != null) {
                    Cart.del(goodVo);
                    System.out.println("删除成功");
                    break;
                } else {
                    System.out.println("您的购物车没有该商品");
                }
            }
        } else {
            System.out.println("您的购物车是空的");
        }
    }

    public void readAll() {
        //购物车商品展示
        for (GoodVo goodVo : Cart.getCart().values()) {
            System.out.println(goodVo);
        }
        System.out.println("购物车总金额为:" +String.format("%.2f",Cart.getBuySum()));
    }

    public void settleMoney() {
        if (Cart.getBuySum().compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("请选择支付方式");
            System.out.println("0.现金支付");
            System.out.println("1.会员卡余额支付");
            System.out.println("2.取消支付");
            payType = input.nextInt();
            switch (payType) {
                case 0:
                    cashPay();
                    break;
                case 1:
                    Pay();
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("购物车为空");
        }
    }

    public void Pay() {
        //会员支付环节
        System.out.println("请输入会员卡号:");
        int memberId = input.nextInt();
        //判断会员是否存在
        boolean isMember = false;
        List<Member> memberList = memberService.selectAll1();
        for (Member member : memberList) {
            if (memberId == member.getMid()) {
                isMember = true;
                this.member = member;
            }
        }
        //确认会员，进行余额支付
        while (true) {
            if (isMember) {
                System.out.println("请输入密码:");
                String password = input.next();
                if (member.getPassword().equals(Encipher.getResult(password))) {
                    BigDecimal balance = this.member.getBalance();
                    //确认余额是否充足
                    if (balance.compareTo(Cart.getBuySum()) >= 0) {
                        accountPay();
                        this.member = null;
                        System.out.println("退出支付系统");
                        break;
                    } else {
                        System.out.println("您的余额不足");
                        System.out.println("1.现金支付");
                        System.out.println("2.充值会员");
                        if (input.nextInt() == 1) {
                            cashPay();
                            break;
                        } else {
                            new MemberCurd().recharge();
                        }
                    }
                }else {
                    System.out.println("密码不正确");
                    break;
                }
            } else {
                System.out.println("你输入的会员卡号不存在");
                System.out.println("1.注册会员");
                System.out.println("2.现金支付");
                if (input.nextInt() == 1) {
                    new MemberCurd().create();
                    break;
                } else {
                    cashPay();
                    break;
                }
            }
        }

    }

    public void accountPay() {
        //余额支付
        Connection connection = null;
        try {
            connection = DbUtil.getConn();
            connection.setAutoCommit(false);
            memberService.reChange(Cart.getBuySum().negate(), member.getMid());
            generateOrder();
            System.out.println("支付成功");
            Cart.clear();
            connection.commit();
        } catch (KeyNotFoundException | SQLException e) {
            System.out.println("余额支付失败");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void cashPay() {
        //现金支付
        Connection connection = null;
        try {
            connection = DbUtil.getConn();
            connection.setAutoCommit(false);
            System.out.println("请付现金");
            generateOrder();
            System.out.println("支付成功");
            Cart.clear();
            connection.commit();
        } catch (Exception e) {
            try {
                System.out.println("现金支付失败");
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public void generateOrder() {
        //生成购买订单
        Order order = null;
        if (payType == 0) {
            order = new Order(1, 0, Cart.getBuySum(), Timestamp.from(Instant.now()), payType);
        } else {
            order = new Order(1, member.getMid(), Cart.getBuySum(), Timestamp.from(Instant.now()), payType);
        }
        int key = orderService.getKey(order);
        System.out.println(key);
        System.out.println("增加了订单: "+orderService.selectOne(key));

        //遍历购物车
        List<OrderDetail> orderDetails = new ArrayList<>(10);
        Cart.getCart().forEach((k, v) -> {
            //更新商品信息
            Good good = v.getGood();
            good.setGoodNum(good.getGoodNum() - v.getBugNum());
            //生成购买订单详情
            orderDetails.add(new OrderDetail(key, good.getGid(), v.getBugNum()));
            if (good.getGoodNum() == 0) {
                good.setState(2);
                good.setChangeTime(Timestamp.from(Instant.now()));
            }
            int update = goodService.update(good);
            if (update > 0) {
                System.out.println("更新" + good.getGoodName() + "的库存为" + good.getGoodNum());
            } else {
                System.out.println("更新失败");
            }
        });
        int addNum = orderDetailService.insertMore(orderDetails);
        System.out.println("增加了"+addNum+"条详情订单");
    }

}