package com.yhh.example;

import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {

    @Test
    public void testListToArray() {
        String[] testStrArr = getArrayFromElems("aaa", "bbb", "ccc", "ddd");
        printArr(testStrArr);

        /*
        result:
            aaa
            bbb
            ccc
            ddd
         */
    }

    @Test
    public void testBinarySearch() throws Exception {
        String[] testStrArr = getArrayFromElems("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg");
        Integer index = Arrays.binarySearch(testStrArr, "ddd");
        PrintUtils.println("index is : " + index);

        /*
        result:
            index is : 3
         */
    }

    @Test
    public void testCopyArray() throws Exception {
        String[] testStrArr = getArrayFromElems("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg");
        String[] newStrArr = Arrays.copyOf(testStrArr, 4);
        printArr(newStrArr);
        /*
        result:
            aaa
            bbb
            ccc
            ddd
         */
    }

    @Test
    public void testStream() throws Exception {
        String[] testStrArr = getArrayFromElems("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg");
        Arrays.stream(testStrArr).forEach(str -> PrintUtils.println(str));

        /*
        result:
            aaa
            bbb
            ccc
            ddd
            eee
            fff
            ggg
         */
    }

    private String[] getArrayFromElems(String... strings) {
        List<String> stringList = Arrays.asList(strings);
        String[] strArr = (String[]) stringList.toArray();
        return strArr;
    }

    private void printArr(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            PrintUtils.println(strArr[i]);
        }
    }
}
