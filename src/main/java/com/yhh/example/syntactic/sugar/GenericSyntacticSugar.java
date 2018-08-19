package com.yhh.example.syntactic.sugar;

import java.util.ArrayList;
import java.util.List;

public class GenericSyntacticSugar {

    public void test() {
        List<String> names = new ArrayList<>();

        names.add("a");

        String name = names.get(0);
    }
}
