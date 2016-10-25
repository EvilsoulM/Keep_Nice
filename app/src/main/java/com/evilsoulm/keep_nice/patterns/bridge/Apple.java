package com.evilsoulm.keep_nice.patterns.bridge;

/**
 * Author by mazixuan
 * Data:2016-10-24 21:24
 * Project:Keep_Nice
 * Detail:
 */

public class Apple implements Brand {
    @Override
    public void sale() {
        System.out.println("Apple");
    }
}
