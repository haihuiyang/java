package com.yhh.example.designPattern.durk;

import com.yhh.common.PrintUtils;

public class MallardMurk extends Duck {

    public MallardMurk() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        PrintUtils.println("I'm a real Mallard duck.");
    }
}
