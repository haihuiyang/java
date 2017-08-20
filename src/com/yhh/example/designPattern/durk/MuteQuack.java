package com.yhh.example.designPattern.durk;

import com.yhh.common.PrintUtils;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        PrintUtils.println("<< Silence >>");
    }
}
