package com.yhh.example.classloading;

public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);//通过子类引用父类的静态字段，不会导致子类初始化

        SuperClass[] superClassArray = new SuperClass[10];//通过数组定义来引用类，不会触发此类的初始化

        System.out.println(ConstClass.HELLO_WORLD);//引用常量池的变量不会触发定义常量的类的初始化

        System.out.println(InterfaceTest.name);//接口的成员变量是 'static final' 的

    }
}
