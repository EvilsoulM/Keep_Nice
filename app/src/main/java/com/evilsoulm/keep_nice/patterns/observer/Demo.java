package com.evilsoulm.keep_nice.patterns.observer;

/**
 * Author by mazixuan
 * Data:2016-10-24 20:15
 * Project:Keep_Nice
 * Detail:
 */

public class Demo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver c1 = new ConcreteObserver();
        ConcreteObserver c2 = new ConcreteObserver();
        ConcreteObserver c3 = new ConcreteObserver();
        c1.setState(10);
        c2.setState(20);
        c3.setState(30);

        subject.registerObserver(c1);
        subject.registerObserver(c2);
        subject.registerObserver(c3);

        //查看未修改时的状态
        System.out.println(c1.getState());
        System.out.println(c2.getState());
        System.out.println(c3.getState());

        System.out.println("-------------修改后的状态-------------");

        //改变目标对象的状态
        subject.setState(1000);
        //查看观察者对象的状态
        System.out.println(c1.getState());
        System.out.println(c2.getState());
        System.out.println(c3.getState());
    }
}
