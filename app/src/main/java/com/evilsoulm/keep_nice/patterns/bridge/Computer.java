package com.evilsoulm.keep_nice.patterns.bridge;

/**
 * Author by mazixuan
 * Data:2016-10-24 21:24
 * Project:Keep_Nice
 * Detail:
 */

public class Computer implements ComputerSale {
    private Brand brand;

    public Computer(Brand brand) {
        this.brand = brand;
    }

    @Override
    public void sale() {
        brand.sale();
    }
}
