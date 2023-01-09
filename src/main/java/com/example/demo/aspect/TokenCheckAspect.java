package com.example.demo.aspect;

import com.example.demo.aspect.annotation.TokenCheck;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TokenCheckAspect {

    @Pointcut("@annotation(com.example.demo.aspect.annotation.TokenCheck)")
    public void po(){

    }


    @Around("po()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        /*TokenCheck annotation = method.getAnnotation(TokenCheck.class);*/
        Object[] args = point.getArgs();
        for (Object o:args) {

        }

        Object result = point.proceed();

        return result;
    }
}
