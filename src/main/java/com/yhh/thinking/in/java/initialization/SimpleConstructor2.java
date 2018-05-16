package com.yhh.thinking.in.java.initialization;

import java.util.stream.IntStream;

class Rock2 {
    public Rock2(int i) {// this is the constructor
        System.out.print("Rock " + i + " ");
    }
}

public class SimpleConstructor2 {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(Rock2::new);
    }
}
