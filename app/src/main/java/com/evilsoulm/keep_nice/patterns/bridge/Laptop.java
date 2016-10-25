package com.evilsoulm.keep_nice.patterns.bridge;

/**
 * Author by mazixuan
 * Data:2016-10-24 21:26
 * Project:Keep_Nice
 * Detail:
 */

public class Laptop extends Computer {

    public Laptop(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("笔记本");
    }
}
