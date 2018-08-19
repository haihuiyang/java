package com.yhh.example.syntactic.sugar;

public class Autoboxing {

    public static void main(String[] args) {

        Integer a = Integer.valueOf(1);                                            //  Integer a = 1;
        Integer b = Integer.valueOf(2);                                            //  Integer b = 2;
        Integer c = Integer.valueOf(3);                                            //  Integer c = 3;
        Integer d = Integer.valueOf(3);                                            //  Integer d = 3;
        Integer e = Integer.valueOf(321);                                          //  Integer e = 321;
        Integer f = Integer.valueOf(321);                                          //  Integer f = 321;
        Long g = Long.valueOf(3);                                                  //  Long g = 3L;
        System.out.println(c == d);                                                //  System.out.println(c == d);
        System.out.println(e == f);                                                //  System.out.println(e == f);

        System.out.println(c.intValue() == (a.intValue() + b.intValue()));         //  System.out.println(c == (a + b));
        System.out.println(c.equals(Integer.valueOf(a.intValue() + b.intValue())));//  System.out.println(c.equals(a + b));
        System.out.println(g.longValue() == (a.intValue() + b.intValue()));        //  System.out.println(g == (a + b));
        System.out.println(g.equals(Integer.valueOf(a.intValue() + b.intValue())));//  System.out.println(g.equals(a + b));

    }
}
