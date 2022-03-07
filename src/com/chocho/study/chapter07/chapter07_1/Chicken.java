package com.chocho.study.chapter07.chapter07_1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_PARAMETER) // 또는 @Target(ElementType.TYPE_USE)
public @interface Chicken {
}
