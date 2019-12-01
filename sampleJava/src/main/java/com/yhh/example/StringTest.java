package com.yhh.example;

import com.javamex.classmexer.MemoryUtil;

import java.nio.charset.Charset;

public class StringTest {

    private static void init_by_int_array() {

        String str = new String(new int[]{43, 48, 49, 122, 121, 65535, 65536}, 0, 7);

        System.out.println(str);

        System.out.println("length is " + str.length());

    }

    private static void init_by_byte_array() {
        Charset charset = Charset.defaultCharset();
        System.out.println(charset);

        String str = new String(new byte[]{'a', 'c', 'f', 'g'}, 0, 3, charset);

        System.out.println(str);

        System.out.println("str.codePointAt(2) " + str.codePointAt(2));
    }

    private static void get_chars() {
        char[] dst = new char[8];
        "abcdefg".getChars(1, 5, dst, 3);
        System.out.println(dst);
    }

    public static void main(String[] args) {

        System.out.println(MemoryUtil.memoryUsageOf(new String("Hello World")));
        System.out.println(MemoryUtil.memoryUsageOf(1));

//        init_by_int_array();
//
//        init_by_byte_array();
//
//        get_chars();

//        String s1 = new String("hello");
//        问：创建了几个 String 对象？
//        答：两个，常量池 "hello" 对象，及堆上 new 出来的

//        case 1
//        String s1 = "hello";
//        String s2 = "hello";
//        System.out.println(s1 == s2);
//        输出 true


//        case 2
//        String s1 = "hello";
//        String s2 = "he" + "ll" + "o";
//        System.out.println(s1 == s2);
//        输出 true


//        case 3
//        String s1 = "hello";
//        String s2 = new String("hello");
//        System.out.println(s1 == s2);
//        输出 false


//        case 4
//        String s1 = "hello";
//        String s2 = "he";
//        String s3 = "llo";
//        String s4 = s2 + s3;
//        System.out.println(s1 == s4);
//        输出 false


//        case 5
//        String s1 = "hello";
//        final String s2 = "he";
//        final String s3 = "llo";
//        String s4 = s2 + s3;
//        System.out.println(s1 == s4);
//        输出 true


//        case 6
//        String s1 = "hello";
//        String s2 = new String("hello");
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s2.intern());
//        输出 false true


//        case 7
//        String s1 = new String("hello");
//        s1.intern();
//        String s2 = "hello";
//        System.out.println(s1 == s2);
//
//        String s3 = new String("wo") + new String("rld");// 步骤 a
//        s3.intern();
//        String s4 = "world";
//        System.out.println(s3 == s4);
//        输出
//        JDK 1.6      : false true
//        JDK 1.7 及以上: false true
//        原因在步骤 a 的时候：s3 = "world"，但是没有把 "world" 放入常量池，s3.intern() 会去常量池找 "world"，发现没有，会把 "world" 放入常量池

        /* case 7 的解释
        ①执行时会在堆内存创建一个值为"str01"的字符串对象str,同时在常量池创建一个"str"以及"01"常量；
        ②执行时会首先去常量池中查看是否存在一个值为"str01"的常量，发现不存在，JDK1.6的做法就是将该字符串"str01"在常量池中也生成一份；
        ③执行时会在常量池中创建一个"str01"对象，发现已经存在，因而不会新建；
        第一个输出false的原因是：str指向的是堆内存的"str01",而str1指向的是常量池中的"str01";
        ④执行时会在堆内存创建一个值为"str01"的字符串对象str2，同时在常量池中创建一个值为"str01"的常量；
        ⑤执行时会首先去常量池中查看是否存在值为"str01"的常量，发现存在，则直接返回这个常量引用；
        ⑥执行时会在常量池中创建一个值为"str01"的常量，如果发现已经存在，则不会创建；
        第二个输出false的原因是：str2指向的是堆内存的"str01"，而str3指向的是常量池中的"str01"；
        ⑦执行时会在常量池创建一个值为"str01"的常量；
        ⑧执行时会在堆内存创建一个值为"str01"的字符串对象str5,同时在常量池创建一个"str"以及"01"常量；
        ⑨执行时会去常量池查看是否存在值为"str01"的常量，发现存在则直接返回这个常量引用；
        第三个输出false的原因是：str5指向的是堆内存的"str01"，而str4指向的是常量池中的"str01"；

        在JDK1.7下输出结果是：
        true
        false
        false
        解释：

        发现只有第一个输出结果不一样，所以我们只解释第一个的原因：
        ①执行时会在堆内存创建一个值为"str01"的字符串对象str,同时在常量池创建一个"str"以及"01"常量；(这点和JDK1.6没什么区别)
        ②执行时会首先去常量池中查看是否存在一个值为"str01"的常量，发现不存在，JDK1.7的做法就是将堆内存中"str01"的引用复制到了常量池中；
        ③执行时会在常量池中创建一个"str01"对象，发现已经存在，因而不会新建；
        那么此时的str和str1都将指向的是堆内存中的"str01"的值，所以两者相等；

        以上就是对JDK1.6和JDK1.7中String类的intern方法的对比,是有差别的，有需要的朋友可以参考下。
         */

//        case 8
//        String s1 = new String("hello");
//        String s2 = "hello";
//        s1.intern();
//        System.out.println(s1 == s2);
//
//        String s3 = new String("wo") + new String("rld");
//        String s4 = "world";
//        s3.intern();
//        System.out.println(s3 == s4);
//        输出
//        JDK 1.6      : false false
//        JDK 1.7 及以上: false false


    }


}
