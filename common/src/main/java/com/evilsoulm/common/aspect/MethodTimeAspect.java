package com.evilsoulm.common.aspect;

import com.evilsoulm.common.Utils.LogUtils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.concurrent.TimeUnit;

/**
 * Author by EvilsoulM
 * Data:2015-12-10 23:12
 * Project:Keep_Nice
 * Detail:
 */
@Aspect
public class MethodTimeAspect {
    private static final String POINTCUT_METHOD =
            "execution(@com.evilsoulm.common.annotation.MethodTime * *(..))";

    private static final String POINTCUT_CONSTRUCTOR =
            "execution(@com.evilsoulm.common.annotation.MethodTime *.new(..))";

    private static final String POINTCUT_NAME = "methodAnnotated() || constructorAnnotated()";

    @Pointcut(POINTCUT_METHOD)
    public void methodAnnotated() {
        LogUtils.log("methodAnnotated() called with: " + "");
    }

    @Pointcut(POINTCUT_CONSTRUCTOR)
    public void constructorAnnotated() {
        LogUtils.log("constructorAnnotated() called with: " + "");
    }

    @Around(POINTCUT_NAME)
    public Object aroundJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        long startTime = System.nanoTime();
        Object result = joinPoint.proceed();
        LogUtils.log(className + "." + methodName + " consume:" + "[" + (TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime)) + "]");

        return result;
    }

    @Before(POINTCUT_NAME)
    public void beforeJoinPoint(JoinPoint joinPoint) throws Throwable {
        //hook before
        //LogUtils.log("beforeJoinPoint() called with: " + "joinPoint = [" + joinPoint + "]");

    }

    @After(POINTCUT_NAME)
    public void afterJoinPoint(JoinPoint joinPoint) throws Throwable {
        //hook after
        //LogUtils.log("afterJoinPoint() called with: " + "joinPoint = [" + joinPoint + "]");
    }
}
