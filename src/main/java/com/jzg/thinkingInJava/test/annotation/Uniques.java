package com.jzg.thinkingInJava.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Uniques {
    Constraints constraints() default @Constraints(unique = true);
}
