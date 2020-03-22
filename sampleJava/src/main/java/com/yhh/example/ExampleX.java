package com.yhh.example;

/**
 * @author happyfeet
 * @since Feb 29, 2020
 */
public class ExampleX {

    /*
    对于给定的域名A和B，判断A是否为B的子域名。
    输入 "123.qq.com", "qq.com" 输出：yes
     */

    public static void main(String[] args) {
        System.out.println(isChildDNS("123.qq.com", "qq.com"));
    }

    public static boolean isChildDNS(String a, String b) {

        String[] bDNSs = b.split("\\.");

        String[] aDNSs = a.split("\\.");

        if (bDNSs.length >= aDNSs.length) {
            return false;
        }

        for (int index = 1; index <= bDNSs.length; index++) {

            if (!bDNSs[bDNSs.length - index].equals(aDNSs[aDNSs.length - index])) {
                return false;
            }
        }
        return true;
    }


}
