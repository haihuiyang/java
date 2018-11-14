package com.yhh.example.designPattern.durk;

import com.yhh.common.PrintUtils;

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        PrintUtils.println("I can't fly.");
    }
}
