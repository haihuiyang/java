package com.yhh.example;

import com.yhh.common.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class AdapterMethodIdiomTest<T> extends ArrayList<T> {

    public AdapterMethodIdiomTest(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed() {
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        //not implemented
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static void main(String[] args) {
        AdapterMethodIdiomTest<Integer> testInteger = new AdapterMethodIdiomTest<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        PrintUtils.println("before reversed : ");
        testInteger.forEach(i -> PrintUtils.println(i));
        PrintUtils.println("after reversed : ");
        testInteger.reversed().forEach(i -> PrintUtils.println(i));

        /*
        result:
            before reversed :
            1
            2
            3
            4
            5
            6
            7
            after reversed :
            7
            6
            5
            4
            3
            2
            1
         */
    }
}