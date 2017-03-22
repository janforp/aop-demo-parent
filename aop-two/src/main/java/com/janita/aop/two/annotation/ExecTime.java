package com.janita.aop.two.annotation;

import java.lang.annotation.*;

/**
 * Created by Janita on 2017-03-22 09:49
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExecTime {
    String value() default "";
}
