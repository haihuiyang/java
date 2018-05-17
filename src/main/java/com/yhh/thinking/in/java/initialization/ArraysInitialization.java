package com.yhh.thinking.in.java.initialization;

public class ArraysInitialization {

    public static void main(String[] args) {
        Dog[] dogs = new Dog[10];

        for (int i = 0; i < dogs.length; i++) {
            System.out.println("dog[" + i + "] = " + dogs[i]);
        }

        System.out.println("new dogs.");

        dogs[0] = new Dog();

        /*
        output:
            dog[0] = null
            dog[1] = null
            dog[2] = null
            dog[3] = null
            dog[4] = null
            dog[5] = null
            dog[6] = null
            dog[7] = null
            dog[8] = null
            dog[9] = null
            new dogs.
            init desc.
            Dog constructor.

         new对象数组的时候, Dog类并没有加载, 只有在给数组初始化Dog对象的时候Dog才被加载
         */
    }

}

class Dog {
    private static String desc;

    static {
        System.out.println("init desc.");
        desc = "I'm a dog.";
    }

    public Dog() {
        System.out.println("Dog constructor.");
    }
}
