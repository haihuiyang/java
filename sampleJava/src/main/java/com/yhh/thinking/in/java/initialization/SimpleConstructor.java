package com.yhh.thinking.in.java.initialization;

import java.util.stream.IntStream;

class Rock {
    public Rock() {// this is the constructor
        System.out.print("Rock ");
    }
}

public class SimpleConstructor {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i -> new Rock());
    }
}
