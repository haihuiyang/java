package com.yhh;

import com.google.common.collect.Lists;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(jvmArgs = {"-Xms4G", "-Xmx4G"})
@Warmup(iterations = 4)
@Measurement(iterations = 8)
public class BenchmarkTest {

    private List<Integer> values;

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setUp() {
        values = IntStream.rangeClosed(0, 100000).boxed().collect(Collectors.toList());
    }

    @Benchmark
    public void by_filter_chain() {
        List<Integer> result = values.stream()
                .filter(value -> value % 17 != 0)
                .filter(value -> value % 16 != 0)
                .filter(value -> value % 15 != 0)
                .filter(value -> value % 14 != 0)
                .filter(value -> value % 13 != 0)
                .collect(Collectors.toList());
//        System.out.println("result size is " + result.size());
    }

    @Benchmark
    public void by_filter_chain_with_parallel_stream() {
        List<Integer> result = values.parallelStream()
                .filter(value -> value % 17 != 0)
                .filter(value -> value % 16 != 0)
                .filter(value -> value % 15 != 0)
                .filter(value -> value % 14 != 0)
                .filter(value -> value % 13 != 0)
                .collect(Collectors.toList());
//        System.out.println("result size is " + result.size());
    }

    @Benchmark
    public void by_each_filter() {

        List<Integer> filter1 = values.stream()
                .filter(value -> value % 17 != 0)
                .collect(Collectors.toList());

        List<Integer> filter2 = filter1.stream()
                .filter(value -> value % 16 != 0)
                .collect(Collectors.toList());

        List<Integer> filter3 = filter2.stream()
                .filter(value -> value % 15 != 0)
                .collect(Collectors.toList());

        List<Integer> filter4 = filter3.stream()
                .filter(value -> value % 14 != 0)
                .collect(Collectors.toList());

        List<Integer> filter5 = filter4.stream()
                .filter(value -> value % 13 != 0)
                .collect(Collectors.toList());

//        System.out.println("result size is " + filter5.size());

    }

    @Benchmark
    public void by_for_loop() {

        List<Integer> results = Lists.newArrayList();

        for (Integer value : values) {
            if (value % 17 != 0
                    && value % 16 != 0
                    && value % 15 != 0
                    && value % 14 != 0
                    && value % 13 != 0) {
                results.add(value);
            }
        }

//        System.out.println("result size is " + result.size());
    }

    @Benchmark
    public void by_for_loop_with_expected_capacity() {

        List<Integer> results = Lists.newArrayListWithCapacity(values.size());

        for (Integer value : values) {
            if (value % 17 != 0
                    && value % 16 != 0
                    && value % 15 != 0
                    && value % 14 != 0
                    && value % 13 != 0) {
                results.add(value);
            }
        }

//        System.out.println("result size is " + result.size());
    }
}
