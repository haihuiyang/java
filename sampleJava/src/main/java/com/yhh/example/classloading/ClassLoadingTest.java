package com.yhh.example.classloading;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.StringTokenizer;

public class ClassLoadingTest {

    public static void main(String[] args) throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            MalformedURLException {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    System.out.println("began load ClassLoader");
                    String fileName = name.substring(name.lastIndexOf('.') + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        String var0 = System.getProperty("java.class.path");
        StringTokenizer var2 = new StringTokenizer(var0, File.pathSeparator);
        List<String> paths = Lists.newArrayListWithCapacity(var2.countTokens());
        while (var2.hasMoreTokens()) {
            paths.add(var2.nextToken());
        }


        Object obj = myLoader.loadClass("com.yhh.example.classloading.ClassLoadingTest").newInstance();

        System.out.println(obj.getClass());

        System.out.println(obj instanceof com.yhh.example.classloading.ClassLoadingTest);


        String pathname = "/Users/yanghaihui/java-1.0-SNAPSHOT.jar";
        URL jarUrl = new File(pathname).toURI().toURL();
        try (URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{jarUrl}, null)) {

            Object o = urlClassLoader.loadClass("com.yhh.example.classloading.ConstClass").newInstance();


            System.out.println("aa");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
