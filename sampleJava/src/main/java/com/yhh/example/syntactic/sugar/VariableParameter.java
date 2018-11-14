package com.yhh.example.syntactic.sugar;

public class VariableParameter {

    public void variable_parameter_test(Object... args) {
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

}
