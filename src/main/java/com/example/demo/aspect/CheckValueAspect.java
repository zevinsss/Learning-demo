package com.example.demo.aspect;

import com.example.demo.aspect.annotation.CheckValue;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class CheckValueAspect {




    @Before("@annotation(com.example.demo.aspect.annotation.CheckValue)")
    public void B (JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {

        }
    }


    @Around("@annotation(com.example.demo.aspect.annotation.CheckValue)")
    public Object A (ProceedingJoinPoint point) throws Throwable {
        Object proceed = point.proceed();
        MethodSignature signature = (MethodSignature) point.getSignature();
       CheckValue cv =  signature.getMethod().getAnnotation(CheckValue.class);

       Object[] s = point.getArgs();
       if (cv.value() == null|| "".equals(cv.value())){
           throw new Exception("运行异常");
       }
       if ("2".equals(cv.value())){
           log.info("参数为2");
       }
        for (Object o : s) {
            log.info("入参是:{}",o.toString());
        }
        return proceed;
    }

}
