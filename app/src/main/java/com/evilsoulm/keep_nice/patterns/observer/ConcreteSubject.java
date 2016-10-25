package com.evilsoulm.keep_nice.patterns.observer;

/**
 * Author by mazixuan
 * Data:2016-10-24 20:11
 * Project:Keep_Nice
 * Detail:
 */

public class ConcreteSubject extends Subject {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObserver();//通知所有观察者
    }
}
