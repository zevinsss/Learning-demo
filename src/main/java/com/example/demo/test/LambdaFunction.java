package com.example.demo.test;

import com.baomidou.mybatisplus.extension.api.R;

@FunctionalInterface
public interface LambdaFunction<T,R> {
    public R getValue(T t1,T t2);
}
