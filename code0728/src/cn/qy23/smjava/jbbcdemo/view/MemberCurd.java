package cn.qy23.smjava.jbbcdemo.view;

import cn.qy23.smjava.jbbcdemo.dao.MemberDao;
import cn.qy23.smjava.jbbcdemo.dao.impl.MemberDaoImpl;
import cn.qy23.smjava.jbbcdemo.entity.Member;
import cn.qy23.smjava.jbbcdemo.service.MemberService;
import cn.qy23.smjava.jbbcdemo.service.impl.MemberServiceImpl;
import cn.qy23.smjava.jbbcdemo.util.Encipher;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/7/30 12:26
 */
public class MemberCurd {
    private Scanner input ;
    private Member member;
    private MemberService memberService;
    private String choice = "y";


    MemberCurd() {
        MemberDao memberDao = new MemberDaoImpl();
        this.memberService = new MemberServiceImpl(memberDao);
        input = new Scanner(System.in);
    }

    public void memberManage() {
        while ("y".equals(choice)) {
            System.out.println("----------1.添加会员信息----------");
            System.out.println("----------2.删除会员信息----------");
            System.out.println("----------3.修改会员信息----------");
            System.out.println("----------4.查询会员信息----------");
            System.out.println("----------5.会员充值--------------");
            System.out.println("----------6.退出------------------");
            int i = input.nextInt();
            switch (i) {
                case 1:
                    create();
                    choice = "y";
                    break;
                case 2:
                    del();
                    choice = "y";
                    break;
                case 3:
                    upd();
                    choice = "y";
                    break;
                case 4:
                    read();
                    choice = "y";
                    break;
                case 5:
                    recharge();
                    choice = "y";
                    break;
                default:
                    choice = "n";
                    break;
            }
        }
    }

    public void create() {
        while ("y".equals(choice)) {
            setInput(0);
            memberService.insert(member);
            System.out.println("是否继续？(y/n)");
            choice = input.next();
        }
    }


    public void upd() {
        while ("y".equals(choice)) {
            System.out.println("请输入会员编号:");
            int mid = input.nextInt();
            setInput(mid);
            memberService.update(member);
            System.out.println("是否继续？(y/n)");
            choice = input.next();
        }
    }

    public void readOne() {
        System.out.println("请输入商品的ID");
        int id = input.nextInt();
        System.out.println(memberService.selectOne(id));
    }

    public void readAll() {
        for (Object member : memberService.selectAll1()) {
            System.out.println(member);
        }
    }

    public void read() {
        while ("y".equals(choice)) {
            System.out.println("1.查询会员编号");
            System.out.println("2.查询所有会员");
            System.out.println("3.退出会员查询");
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

    public void del() {
        while ("y".equals(choice)) {
            System.out.println("请输入要删除的会员编号:");
            int id = input.nextInt();
            memberService.delete(id);
            System.out.println("是否继续？(y/n)");
            choice = input.next();
        }
    }

    public void recharge() {
        while ("y".equals(choice)) {
            System.out.println("请输入会员编号:");
            int id = input.nextInt();
            System.out.println("请输入充值金额:");
            BigDecimal credit = input.nextBigDecimal();
            memberService.reChange(credit, id);
            System.out.println("是否继续？(y/n)");
            choice = input.next();
        }
    }

    public Member setInput(int mid) {
        System.out.println("请输入会员名:");
        String mName = input.next();
        System.out.println("请输入会员密码:");
        String password = Encipher.getResult(input.next());
        System.out.println(password);
        System.out.println("请输入联系方式:");

        String phone = input.next();
        boolean x =true;
        while (x) {
            if (isLegalInputLine(phone)) {
                isLegalInputLine(phone);
                x =false;
            }else {
                System.out.println("输入格式有误，重新输入");
                phone = input.next();
            }
        }

        System.out.println("请输入积分:");
        float score = input.nextFloat();
        Timestamp createTime = Timestamp.from(Instant.now());
        Timestamp changeTime = Timestamp.from(Instant.now());
        member = new Member(1, mName, password, phone, score, BigDecimal.valueOf(0), createTime, changeTime);
        return member;
    }


    public  boolean isLegalInputLine(String line ) {
        Pattern p = Pattern.compile("^(13[0-9]|17[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");
        Matcher m = p.matcher(line);
        boolean r = m.matches();
        return r;
    }

}

