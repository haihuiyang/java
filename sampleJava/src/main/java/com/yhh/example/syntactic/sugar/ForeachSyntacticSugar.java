package com.yhh.example.syntactic.sugar;

import java.util.Arrays;
import java.util.List;

public class ForeachSyntacticSugar {

    public static void main(String[] args) {
        List names = Arrays.asList(1, "sd");
        for (Object name : names) {
            System.out.println(name);
        }
    }

}
