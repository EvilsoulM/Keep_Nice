package com.evilsoulm.keep_nice.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author by mazixuan
 * Data:2016-10-25 11:20
 * Project:Keep_Nice
 * Detail:
 */

public class StarHandler implements InvocationHandler {
    private Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("真实角色调用之前的处理");
        if (method.getName().equals("sing")) {
            object = method.invoke(realStar, args);
        }
        System.out.println("真实角色调用之后的处理.....");
        return object;
    }
}
