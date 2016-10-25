package com.evilsoulm.keep_nice.patterns.strategy;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:28
 * Project:Keep_Nice
 * Detail:
 */

public class GeneralUser implements Strategty {
    @Override
    public double getPrice(double price) {
        System.out.println("普通用户，不打折");
        return price;
    }
}
