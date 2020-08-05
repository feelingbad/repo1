package cn.qy23.smjava.jbbcdemo.entity;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/8/1 14:37
 */
public class Cart {
    private static HashMap<Integer, GoodVo> cart;
    private static BigDecimal buySum;

    static {
        cart = new HashMap<>(10);
        buySum = new BigDecimal(0);
    }


    public static void add(Good good, int buyNum) {
        GoodVo goodVo = cart.get(good.getGid());
        if (goodVo != null) {
            goodVo.setBugNum(buyNum);
        } else {
            goodVo = new GoodVo(good, buyNum);
            cart.put(good.getGid(), goodVo);
        }
        buySum = buySum.add(goodVo.getBugTotal());
    }

    public static void del(GoodVo goodVo) {
        cart.remove(goodVo.getGood().getGid());
        buySum = buySum.subtract(goodVo.getBugTotal());
    }

    public static boolean upd(GoodVo goodVo, int buyNum) {
        if (goodVo.getGood().getGoodNum() >= buyNum) {
            buySum = buySum.subtract(goodVo.getBugTotal());
            goodVo.setBugNum(buyNum);
            buySum = buySum.add(goodVo.getBugTotal());
            return true;
        } else if (buyNum <= 0) {
            System.out.println("数量要大于0");
        }
        return false;
    }

    public static GoodVo isBuy(int id) {
        GoodVo goodVo = null;
        for (int haveBugId : Cart.getCart().keySet()) {
            if (haveBugId == id) {
                goodVo = Cart.getCart().get(id);
                return goodVo;
            }
        }
        return null;
    }

    public static void clear() {
        cart.clear();
        buySum = buySum.subtract(buySum);
    }

    public static HashMap<Integer, GoodVo> getCart() {
        return cart;
    }

    public static BigDecimal getBuySum() {
        return buySum;
    }
}
