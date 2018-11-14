package com.yhh.thinking.in.java.initialization;

public class StaticInitialization {

    static Table table = new Table();//@1
    static Cupboard cupboard = new Cupboard();//@2

    public static void main(String[] args) {
        System.out.println("Creating new Cupboard() in main.");
        new Cupboard();//@3
        System.out.println("Creating new Cupboard() in main.");
        new Cupboard();//@4
        table.f2(1);//@5
        cupboard.f3(1);//@6

        /*
        output:
            Bowl(1)
            Bowl(2)
            Table()
            f1(1)   //static Table table = new Table();
            Bowl(4)
            Bowl(5)
            Bowl(3)
            Cupboard()
            f1(2)   //static Cupboard cupboard = new Cupboard();
            Creating new Cupboard() in main.
            Bowl(3)
            Cupboard()
            f1(2)   //new Cupboard();
            Creating new Cupboard() in main.
            Bowl(3)
            Cupboard()
            f1(2)   //new Cupboard();
            f2(1)   //table.f2(1);
            f3(1)   //cupboard.f3(1);

          static类型变量只会被初始化一次
          其余部分按照顺序执行
         */


    }
}

class Bowl {
    public Bowl(int marker) {
        System.out.println("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);//@1

    public Table() {
        System.out.println("Table()");
        bowl2.f1(1);//@3
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);//@2
}

class Cupboard {
    Bowl bowl3 = new Bowl(3);//@3
    static Bowl bowl4 = new Bowl(4);//@1

    public Cupboard() {
        System.out.println("Cupboard()");
        bowl4.f1(2);//@4
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);//@2
}
