package com.evilsoulm.keep_nice.patterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by mazixuan
 * Data:2016-10-24 20:07
 * Project:Keep_Nice
 * Detail:
 */

public class Subject {
    protected List<Observer> list = new ArrayList<Observer>();

    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    public void removeObserver(Observer observer) {
        list.remove(observer);
    }

    public void notifyAllObserver() {
        for (Observer observer : list) {
            observer.upadte(this);
        }
    }
}
