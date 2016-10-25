package com.evilsoulm.keep_nice.patterns.adapter;

/**
 * Author by mazixuan
 * Data:2016-10-24 21:10
 * Project:Keep_Nice
 * Detail:
 */

public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleReq() {
        adaptee.request();
    }
}
