package com.yhh.example;

import com.google.common.collect.Maps;
import com.yhh.common.PrintUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void testInitialMap() {
        Map<String, String> map = new HashMap<String, String>() {{
            put("key1", "value1");
            put("key2", "value2");
            put("key3", "value3");
        }};

        PrintUtils.println(map);
        /*
        result:
            {key1=value1, key2=value2, key3=value3}
         */
    }

    @Test
    public void name() {
        Map<String, Integer> test = Maps.newHashMap();

        test.put("a", 1);
        test.put("b", 1);
        test.put("c", 1);

//        test.merge("a", 2, (a, b) -> a + b);
//        test.merge("b", 2, (a, b) -> a + b);

        System.out.println(test);
    }

    @Test
    public void test1() {
        System.out.println(tableSizeFor(32));
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}
