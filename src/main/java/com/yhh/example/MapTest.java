package com.yhh.example;

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
}
