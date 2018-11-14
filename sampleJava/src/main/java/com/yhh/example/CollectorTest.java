package com.yhh.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorTest {

    public static void main(String[] args) {
        List<String> strs = IntStream.range(10, 100)
                .boxed()
                .map(Object::toString)
                .collect(ArrayList::new, ArrayList::add, List::addAll);

        List<String> strs1 = IntStream.range(10, 100)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.toList());
        
    }

}
