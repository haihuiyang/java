package com.yhh.example.designPattern.durk;

import com.yhh.common.PrintUtils;

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        PrintUtils.println("I'm flying!!");
    }
}
