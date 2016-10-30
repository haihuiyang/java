package com.yhh.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yanghaihui on 10/24/16.
 */
public class TestCollections {

    public static void main(String[] args) {

        List<?> list = Collections.EMPTY_LIST;

        List<String> strList = Arrays.asList(new String[]{"2", "1", "3", "-1"});

        Collections.sort(strList);

        strList.stream().forEach(s -> System.out.print(s + " "));

        Collections.unmodifiableList(strList);

        //strList.add("23");
        //抛出java.lang.UnsupportedOperationException
    }

}
