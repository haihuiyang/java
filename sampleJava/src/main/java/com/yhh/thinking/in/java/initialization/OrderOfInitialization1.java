package com.yhh.thinking.in.java.initialization;

public class OrderOfInitialization1 {

    public static void main(String[] args) {
        House house = new House();
        house.f();
        /*
        output:
            Window(1)
            Window(2)
            Window(3)
            House()
            Window(33)
            f()
         成员变量的初始化按照定义的顺序初始化，然后执行构造方法里面的初始化语句
         */
    }

}

class Window {
    Window(int market) {
        System.out.println("Window(" + market + ")");
    }
}

class House {
    Window w1 = new Window(1);//before constructor

    House() {
        //show we're in constructor
        System.out.println("House()");
        w3 = new Window(33);//reinitialize w3
    }

    Window w2 = new Window(2);//after constructor

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);//at end
}