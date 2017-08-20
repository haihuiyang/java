package com.yhh.example;

import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.text.DecimalFormat;

public class DoubleTest {

    @Test
    public void testDoubleFormat() throws Exception {
        Double aDouble = 0.0000012;
        DecimalFormat format1 = new DecimalFormat("0.0000000000");
        PrintUtils.println(format1.format(aDouble));

        DecimalFormat format2 = new DecimalFormat("0.000000");
        PrintUtils.println(format2.format(aDouble));

        /*
        result:
            0.0000012000
            0.000001
         */
    }
}
