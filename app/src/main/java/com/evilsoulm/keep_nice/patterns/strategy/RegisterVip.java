package com.evilsoulm.keep_nice.patterns.strategy;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:32
 * Project:Keep_Nice
 * Detail:
 */

public class RegisterVip implements Strategty {
    @Override
    public double getPrice(double price) {
        System.out.println("普通会员：打8折");
        return price * 0.8;
    }
}
