package com.yhh.example.exception;

import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTest {

    @Test
    public void testMyIllegalArgumentExceptions() throws Exception {
        try {
            throw new MyIllegalArgumentExceptions("test", "this is a MyIllegalArgumentExceptions.");
        } catch (MyIllegalArgumentExceptions e) {
            PrintUtils.println(e);
        }
        /*
        result:
            field is test; message is this is a MyIllegalArgumentExceptions.
         */
    }

    @Test
    public void testFinally() throws Exception {
        File file = new File("/this/is/a/error/path/");
        try {
            FileReader fileReader = new FileReader(file);
            PrintUtils.println("This won't execute.");
        } catch (FileNotFoundException e) {
            PrintUtils.println("Catch FileNotFoundException is : " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            PrintUtils.println("Catch ArrayIndexOutOfBoundsException is : " + e);
        } finally {
            PrintUtils.println("This is finally block.");
        }
        /*
        result:
            catch FileNotFoundException is : java.io.FileNotFoundException: /this/is/a/error/path (No such file or directory)
            this is finally block.
         */
        /*
        finally里面的语句总是会执行的。
         */
    }
}
