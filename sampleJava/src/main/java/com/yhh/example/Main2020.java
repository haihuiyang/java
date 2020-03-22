package com.yhh.example;

import java.util.Scanner;

/**
 * @author happyfeet
 * @since Mar 06, 2020
 */
public class Main2020 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        invertedOrderPrint(str);

    }

    private static void invertedOrderPrint(String str) {

        int strIndex = str.length() - 1;

        while (strIndex >= 0) {
            // 去除尾巴上非 a-z A-Z 0-9 的字符
            while (strIndex >= 0 && !isNormalChar(str.charAt(strIndex))) {
                strIndex--;
            }

            boolean needRecursion = true;
            int endIndex = strIndex;

            while (needRecursion) {
                while (strIndex >= 0 && isNormalChar(str.charAt(strIndex))) {
                    strIndex--;
                }

                // 字符中间出现了 -
                if (strIndex >= 0 && isBar(str.charAt(strIndex))) {
                    strIndex--;

                    // 如果 - 前面是非 a-z A-Z 0-9 的字符，则可以跳出循环，否则，继续本 while 循环
                    if (strIndex < 0 || !isNormalChar(str.charAt(strIndex))) {
                        int startIndex = strIndex + 2;
                        System.out.print(str.substring(startIndex, endIndex + 1) + " ");
                        needRecursion = false;
                    }
                } else {
                    // 两种情况：
                    // 1、strIndex == -1 说明到了字符串的起点
                    // 2、出现了非 a-z A-Z 0-9 - 的其他非法字符，可以跳出循环
                    System.out.print(str.substring(strIndex + 1, endIndex + 1) + " ");
                    needRecursion = false;
                }
            }
        }
    }

    private static boolean isNormalChar(char aChar) {
        return (aChar >= '0' && aChar <= '9')
                || (aChar >= 'a' && aChar <= 'z')
                || (aChar >= 'A' && aChar <= 'Z');
    }

    private static boolean isBar(char aChar) {
        return aChar == '-';
    }

}
