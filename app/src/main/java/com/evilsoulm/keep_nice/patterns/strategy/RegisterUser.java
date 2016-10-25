package com.evilsoulm.keep_nice.patterns.strategy;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:28
 * Project:Keep_Nice
 * Detail:
 */

public class RegisterUser implements Strategty {
    @Override
    public double getPrice(double price) {
        System.out.println("注册用户：打9折");
        return price * 0.9;
    }
}
