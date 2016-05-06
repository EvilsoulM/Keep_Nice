package com.evilsoulm.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author by EvilsoulM
 * Data:2015-12-10 23:39
 * Project:Keep_Nice
 * Detail:
 */
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface CheckUrl {
}
