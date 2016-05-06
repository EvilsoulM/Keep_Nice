package com.evilsoulm.common.aspect;

import android.text.TextUtils;

import com.evilsoulm.common.Utils.LogUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Author by EvilsoulM
 * Data:2015-12-10 23:41
 * Project:Keep_Nice
 * Detail:
 */
@Aspect
public class CheckUrlAspect {

    @Pointcut("execution(* com.evilsoulm.common.Utils.ImageLoader.loadImage(String,..))")
    public void loadImageEntryPoint(String imageUri) {
    }

    @Around(value = "loadImageEntryPoint(imageUri)")
    public Object loadImageMethod(ProceedingJoinPoint joinPoint, String imageUri) throws Throwable {
        LogUtils.log("call -> loadImageMethod");
        if (TextUtils.isEmpty(((String) joinPoint.getArgs()[0]))) {
            return null;
        }
        return joinPoint.proceed();
    }
}
