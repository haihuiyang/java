package com.yhh.example.designPattern.durk;

import com.yhh.common.PrintUtils;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        PrintUtils.println("Quack.");
    }
}
