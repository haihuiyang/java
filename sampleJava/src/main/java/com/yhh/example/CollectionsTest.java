package com.yhh.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    @Test
    public void testUnmodifiableCollection() {
        List<String> stringList = new ArrayList<String>() {{
            add("aaaa");
            add("bbbb");
            add("cccc");
            add("dddd");
        }};
        stringList.add("eeee");
        List<String> unmodifiableList = Collections.unmodifiableList(stringList);
        unmodifiableList.add("ffff");
        /*
        result:
            java.lang.UnsupportedOperationException
                at java.util.Collections$UnmodifiableCollection.add(Collections.java:1055)
                at com.yhh.example.TestCollections1.testUnmodifiableCollection(TestCollections1.java:38)
         */

        /*
        Collections.unmodifiableList()方法返回了一个新的不可修改的list。
         */
    }

}
