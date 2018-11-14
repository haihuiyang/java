package com.yhh.thinking.in.java.initialization;

public class OrderOfInitialization2 {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();

        /*
        output:
            new Print(1)
            new Print(2)
            new SuperClass()
            new Print(3)
            new Print(4)
            new SubClass()
        先调用了父类SuperClass类的构造函数，然后才是SubClass类的构造函数
         */
    }

}

class Print {
    Print(int i) {
        System.out.println("new Print(" + i + ")");
    }
}

class SuperClass {
    Print print1 = new Print(1);

    public SuperClass() {
        System.out.println("new SuperClass()");
    }

    Print print2 = new Print(2);
}

class SubClass extends SuperClass {
    Print print3 = new Print(3);

    public SubClass() {
        //这个地方其实是调用了父类的默认的无参构造函数，super();
        //如果父类没有无参构造函数，则这个地方必须显式的调用父类的构造函数，否则编译不通过
        System.out.println("new SubClass()");
    }

    Print print4 = new Print(4);
}
