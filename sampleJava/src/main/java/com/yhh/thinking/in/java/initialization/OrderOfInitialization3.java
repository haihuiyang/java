package com.yhh.thinking.in.java.initialization;

public class OrderOfInitialization3 {

    public static void main(String[] args) {
        Man man = new Man();
        Man man1 = new Man();

        /*
        output:
            new Print(0)
            new Print(5)
            new Print(6)
            new Print(1)
            new Print(2)
            new People()
            new Print(3)
            new Print(4)
            new Man()
            new Print(1)
            new Print(2)
            new People()
            new Print(3)
            new Print(4)
            new Man()
         */
    }

    static Print1 print1 = new Print1(0);
}

class Print1 {
    Print1(int i) {
        System.out.println("new Print1(" + i + ")");
    }
}

class People {
    Print1 print1 = new Print1(1);

    public People() {
        System.out.println("new People()");
    }

    Print1 print2 = new Print1(2);

    static Print1 print5 = new Print1(5);
}

class Man extends People {

    Print1 print3 = new Print1(3);

    public Man() {
        System.out.println("new Man()");
    }

    Print1 print4 = new Print1(4);

    static Print1 print6 = new Print1(6);
}
