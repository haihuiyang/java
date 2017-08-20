package com.yhh.example.designPattern.durk;

import com.yhh.common.PrintUtils;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        PrintUtils.println("Squeak");
    }
}
