package com.yhh.example;

import com.yhh.common.PrintUtils;
import org.junit.Test;

public class StaticTest {

    private static String staticField;

    static {
        staticField = "this is a static field.";
        PrintUtils.println(staticField);
    }

    {
        PrintUtils.println("instance has been created.");
    }

    @Test
    public void testStatic() {
        StaticTest obj1 = new StaticTest();
        StaticTest obj2 = new StaticTest();
        StaticTest obj3 = new StaticTest();
        /*
        result:
            this is a static field.
            instance has been created.
            instance has been created.
            instance has been created.
            instance has been created.
         */

        /*
        首先，执行test本身就是创建了一个StaticTest的实例，然后再创建了新的三个实例，从输出的结果来看，static块里面的语句只会执行一遍。
         */
    }
}
