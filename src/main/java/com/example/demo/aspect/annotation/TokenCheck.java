package com.example.demo.aspect.annotation;

import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LuoHongMiao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenCheck {
    String value() default "";
}
