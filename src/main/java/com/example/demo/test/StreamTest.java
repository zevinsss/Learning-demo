package com.example.demo.test;

import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    List<String> list = Arrays.asList("a", "b", "c");


    // 创建一个顺序流
    Stream<String> stream = list.stream();

    // 创建一个并行流

    Stream<String> parallelStream = list.parallelStream();

    private Environment environment;


}
