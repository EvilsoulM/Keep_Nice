package com.evilsoulm.keep_nice.patterns.observer;

/**
 * Author by mazixuan
 * Data:2016-10-24 20:10
 * Project:Keep_Nice
 * Detail:
 */

public class ConcreteObserver implements Observer {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void upadte(Subject subject) {
        this.state = ((ConcreteSubject) subject).getState();
    }
}
