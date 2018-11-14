package com.yhh.example;

import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void testBigDecimalOperator() {
        BigDecimal num1 = new BigDecimal(41.429259);
        BigDecimal num2 = new BigDecimal(3.373448);
        BigDecimal result = num1.subtract(num2).divide(num1, 6, BigDecimal.ROUND_HALF_UP);
        PrintUtils.println(result.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
        /*
        result:
            91.86
         */
    }

    @Test
    public void test_big_decimal_bug() {
        BigDecimal bd1 = BigDecimal.valueOf(21232142532451311.8);
        PrintUtils.println(bd1);

        BigDecimal bd2 = BigDecimal.valueOf(2123214253245131545.3);
        PrintUtils.println(bd2);

        /*
        result:
            21232142532451312
            2123214253245131520
         */

        /*
        这个结果是因为 double 的精度问题：
        使用 Double.toString(2123214253245131545.3) 之后 得到 "2.12321425324513152E18", 这个时候数字已经丢失精度了
        使用 Double.toString(21232142532451311.8) 之后   得到 "2.1232142532451312E16", 这个时候数字已经丢失精度了
         */
    }

    @Test
    public void test_create_big_decimal() {
        BigDecimal useDoubleCreate = new BigDecimal(1.01);
        System.out.println("useDoubleCreate  : " + useDoubleCreate);

        BigDecimal useValueOfCreate = BigDecimal.valueOf(1.01);
        System.out.println("useValueOfCreate : " + useValueOfCreate);
    }

    @Test
    public void test_two_ways_compare_big_decimal() {
        BigDecimal two1 = new BigDecimal("2.0");
        BigDecimal two2 = new BigDecimal("2.00");

        System.out.println("two1 equals    two2 is " + two1.equals(two2));
        System.out.println("two1 compareTo two2 is " + two1.compareTo(two2));
    }

    @Test
    public void test_big_decimal_is_final_object() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal c = a.add(new BigDecimal("2.0"));
        System.out.println("after add a = " + a);
        System.out.println("c = " + c);
    }
}
