package com.yhh.example;

import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    @Test
    public void testBigDecimalOperator() throws Exception {
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
    public void testBigDecimalBug() throws Exception {
        BigDecimal bd1 = new BigDecimal(21232142532451311.8);
        PrintUtils.println(bd1);

        BigDecimal bd2 = new BigDecimal(2123214253245131545.3);
        PrintUtils.println(bd2);
        /*
        result:
            21232142532451312
            2123214253245131520
         */

        // TODO: 8/20/17
        /*
        这个结果肯定是有问题的，是BigDecimal的位数问题还是其他，有待查证
         */
    }
}
