package com.yhh.thinking.in.java.initialization;

public class InitialValues {

    private boolean t;
    private char c;
    private byte b;
    private short s;
    private int i;
    private long l;
    private float f;
    private double d;
    private InitialValues reference;

    void printInitialValues() {
        System.out.println("Data type  Initial value");
        System.out.println("boolean    " + t);
        System.out.println("char       " + c);
        System.out.println("byte       " + b);
        System.out.println("short      " + s);
        System.out.println("int        " + i);
        System.out.println("long       " + l);
        System.out.println("float      " + f);
        System.out.println("double     " + d);
        System.out.println("reference  " + reference);
    }

    public static void main(String[] args) {
        new InitialValues().printInitialValues();

        /*
        output:
            boolean    false
            char        
            byte       0
            short      0
            int        0
            long       0
            float      0.0
            double     0.0
            reference  null
         */
    }

}
