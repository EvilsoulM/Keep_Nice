package com.evilsoulm.keep_nice.common.parser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author by mazixuan
 * Data:2016-07-17 22:39
 * Project:Keep_Nice
 * Detail:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewBinder {
    int id() default -1;
}
