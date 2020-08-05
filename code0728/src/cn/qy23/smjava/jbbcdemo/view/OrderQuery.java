package cn.qy23.smjava.jbbcdemo.view;

import cn.qy23.smjava.jbbcdemo.dao.OrderDao;
import cn.qy23.smjava.jbbcdemo.dao.OrderDetailDao;
import cn.qy23.smjava.jbbcdemo.dao.impl.OrderDetailDaoImpl;
import cn.qy23.smjava.jbbcdemo.dao.impl.OrderImpl;
import cn.qy23.smjava.jbbcdemo.entity.Order;
import cn.qy23.smjava.jbbcdemo.entity.OrderDetail;
import cn.qy23.smjava.jbbcdemo.service.OrderDetailService;
import cn.qy23.smjava.jbbcdemo.service.OrderService;
import cn.qy23.smjava.jbbcdemo.service.impl.OrderDetailServiceImpl;
import cn.qy23.smjava.jbbcdemo.service.impl.OrderServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/31 18:02
 */
public class OrderQuery {
    public Scanner input = new Scanner(System.in);
    public OrderDao orderDao;
    public OrderDetail orderDetail;
    public OrderService orderService;
    public OrderDetailService orderDetailService;

    public OrderQuery() {
        OrderDao orderDao = new OrderImpl();
        orderService = new OrderServiceImpl(orderDao);
        OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
        orderDetailService = new OrderDetailServiceImpl(orderDetailDao);
    }

    public void orderQuery() {
        String choice = "y";
        while ("y".equals(choice)) {
            System.out.println("1.会员编号查询");
            System.out.println("2.商品编号查询");
            System.out.println("3.退出查询");
            int x = input.nextInt();
            switch (x) {
                case 1:
                    memberQuery();
                    break;
                case 2:
                    goodQuery();
                    break;
                default:
                    choice = "n";
                    break;
            }
        }
    }

    public void memberQuery() {
        System.out.println("请输入会员编号");
        int memberId = input.nextInt();
        boolean e = false;
        List<Order> orderList = orderService.selectAll1();
        System.out.println("订单信息如下:");
        for (Order order : orderList) {
            if (order.getUserId() == memberId) {
                System.out.println(order);
                e = true;
            }
        }
        if (!e) {
            System.out.println("没有购买记录");
        }
    }

    public void goodQuery() {
        System.out.println("输入商品编号");
        int goodId = input.nextInt();
        boolean e = false;
        List<OrderDetail> OrderDetailList = orderDetailService.selectAll1();
        System.out.println("订单信息如下:");
        for (OrderDetail orderDetail : OrderDetailList) {
            if (orderDetail.getBgId() == goodId) {
                System.out.println(orderDetail);
                e = true;
            }
        }
        if (!e) {
            System.out.println("没有该商品的购买记录");
        }
    }
}
