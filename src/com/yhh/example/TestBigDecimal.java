package com.yhh.example;

import java.math.BigDecimal;

/**
 * Created by yanghaihui on 10/19/16.
 */
public class TestBigDecimal {

    public static void main(String[] args) {
        BigDecimal num1 = new BigDecimal(41.429259);
        BigDecimal num2 = new BigDecimal(3.373448);

        BigDecimal result = num1.subtract(num2).divide(num1, 6, BigDecimal.ROUND_HALF_UP);

        System.out.println(result.multiply(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
