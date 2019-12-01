package com.yhh.example;

import com.yhh.common.PrintUtils;
import com.yhh.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class LambdaTest {

    private static final List<String> stringList = new ArrayList<String>() {{
        add("aa");
        add("bb");
        add("cc");
        add("dd");
    }};

    private static final List<Integer> integerList = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
        add(4);
    }};

    private static final List<User> userList = new ArrayList<User>() {{
        add(new User("Bob", "Street 1", 22));
        add(new User("Mike", "Street 2", 21));
        add(new User("Lily", "Street 3", 18));
        add(new User("Uncle Bob", "Street 4", 34));
    }};

    @Test
    public void testForeach() {
        stringList.stream().forEach(PrintUtils::println);

        /*
        result:
            aa
            bb
            cc
            dd
         */
    }

    @Test
    public void testParallelStream() {
        stringList.parallelStream().forEach(PrintUtils::println);
        /*
        result:
            bb
            dd
            aa
            cc

            bb
            cc
            aa
            dd
         */

        /*
        parallelStream：并行流。启动的线程数跟机器的cpu核数一致。当顺序无关紧要时使用parallelStream能提高性能，
        但要确保everything is thread-safe！

        使用场景：
        1、I have a massive amount of items to process (or the processing of each item takes time and is parallelizable)；
        2、I have a performance problem in the first place；
        3、I don't already run the process in a multi-thread environment (for example:
           in a web container, if I already have many requests to process in parallel,
           adding an additional layer of parallelism inside each request could have more negative than positive effects)；
         */
    }

    @Test
    public void testFilter() {
        stringList.stream().filter(s -> s.startsWith("a") || s.startsWith("b"))
                .forEach(PrintUtils::println);

        /*
        result:
            aa
            bb
         */

        /*
        filter里面是一个断言（Predicate），用于筛选满足条件的对象，例如，下面就是一个断言，用于筛选stringList中以"a"和"b"开头的字符。
        s -> s.startsWith("a") || s.startsWith("b")
         */
    }

    @Test
    public void testMap() {
        stringList.stream().map(String::toUpperCase).forEach(PrintUtils::println);

        /*
        result:
            AA
            BB
            CC
            DD
         */

        /*
        map里面是一个函数，上例就是将stringList里面的每一个元素做一个mapping，全部转化为大写字母。
         */
    }

    @Test
    public void testReduce() {
        Optional<Integer> sumOptional = integerList.stream().reduce(Integer::sum);
        sumOptional.ifPresent(PrintUtils::println);

        /*
        result:
            10
         */

        /*
        reduce里面是一个将两个数合并成一个数的函数，(a, b) -> a + b：将两个数求和
         */
    }

    @Test
    public void testToMap() {
        Map<String, User> nameUserMap = userList.stream().collect(Collectors.toMap(User::getUserName, user -> user));

        nameUserMap.keySet().forEach(userName -> PrintUtils.println(nameUserMap.get(userName)));

        /*
        result:
            userName is Mike; address is Street 2; age is 21
            userName is Bob; address is Street 1; age is 22
            userName is Uncle Bob; address is Street 4; age is 34
            userName is Lily; address is Street 3; age is 18
         */
    }
}
