package com.yhh.example;

import com.yhh.common.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanghaihui on 10/27/16.
 * <p>
 * throw : You can throw an exception by using throw keyword.
 * <p>
 * throws : If a method does not handle a checked exception,the method must declare it using the throws keyword.
 */
public class TestExceptions {
    public static void main(String[] args) {
        TestExceptions testExceptions = new TestExceptions();

//        testExceptions.test1();
//        testExceptions.test2();
        try {
            testExceptions.test3("sss");
        } catch (MyExceptions e) {
            Utils.print(e.getMessage());
        }


    }

    private void test2() {
        int[] ints = new int[2];

        List<String> list = new ArrayList<>();
        try {
            Utils.print("get the first element from list." + list.get(0));
            Utils.print("get element three :" + ints[3]);
        } catch (NullPointerException | IndexOutOfBoundsException ex) {
            Utils.print("catch the exceptions." + ex);
            throw ex;
        }
    }

    private void test1() {
        Integer[] ints = new Integer[2];

        int[] ints1 = new int[2];

        File file = new File("/Users/yanghaihui/Downloads/短_风险分析_20161026.xlsx");

        int i;
        try {
            FileReader fr = new FileReader(file);

            i = ints1[1];
            Utils.print("get element three :" + ints[3]);

        } catch (FileNotFoundException e) {//catch ex and do something
            Utils.print("catch one exception is : " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            Utils.print("catch two exception is : " + e);
            i = 0;
        } finally {
            //always executes.
            Utils.print("this is finally block.");
        }
    }

    private void test3(String username) throws MyExceptions {
        if (!username.equals("sunshine")) {
            throw new MyExceptions();
        }
        Utils.print("this is my username.");
    }
}

//UDE(User-defined Exceptions)
class MyExceptions extends Exception {
    private String msg = "this is not my username.";

    @Override
    public String getMessage() {
        return this.msg;
    }
}
