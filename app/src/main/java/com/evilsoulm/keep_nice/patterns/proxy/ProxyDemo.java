package com.evilsoulm.keep_nice.patterns.proxy;

import java.lang.reflect.Proxy;

/**
 * Author by mazixuan
 * Data:2016-10-25 11:13
 * Project:Keep_Nice
 * Detail:
 */

public class ProxyDemo {
    public static void main(String[] args) {

        //静态代理 ---------------------
//        Star real = new RealStar();
//        Star proxy = new ProxyStar(real);
//        proxy.confer();
//        proxy.signContract();
//        proxy.bookTicket();
//        proxy.sing();
//        proxy.collectMoney();

        //动态代理 ---------------------
        //真实角色
        Star realStar = new RealStar();
        //处理器
        StarHandler handler = new StarHandler(realStar);
        //代理类
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        proxy.sing();//调用代理类的唱歌方法：其实调用的是真实角色的唱歌方法

    }
}
