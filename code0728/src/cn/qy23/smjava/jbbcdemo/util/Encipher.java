package cn.qy23.smjava.jbbcdemo.util;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author p庞振宇
 * @version 1.0
 * @date 2020/8/2 14:20
 */
public class Encipher {
    public static final String KEY_MD5 = "MD5";

    public static String getResult(String inputStr) {
        BigInteger bigInteger = null;

        try {
            MessageDigest md = MessageDigest.getInstance(KEY_MD5);
            byte[] inputData = inputStr.getBytes();
            md.update(inputData);
            bigInteger = new BigInteger(md.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigInteger.toString(16);
    }
}
