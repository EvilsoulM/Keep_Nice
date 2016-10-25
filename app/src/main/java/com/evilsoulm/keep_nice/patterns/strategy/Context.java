package com.evilsoulm.keep_nice.patterns.strategy;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:35
 * Project:Keep_Nice
 * Detail:
 */

public class Context {
    private Strategty strategty;

    public Context(Strategty strategty) {
        this.strategty = strategty;
    }

    public void printPrice(double price) {
        System.out.println("应付金额：" + Math.round(strategty.getPrice(price)));
    }
}
