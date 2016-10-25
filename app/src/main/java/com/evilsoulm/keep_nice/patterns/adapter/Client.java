package com.evilsoulm.keep_nice.patterns.adapter;

/**
 * Author by mazixuan
 * Data:2016-10-24 21:11
 * Project:Keep_Nice
 * Detail:
 */

public class Client {
    public static void main(String[] args) {
        Client c = new Client();
        Adaptee a = new Adaptee();
        Target t = new Adapter(a);
        c.test1(t);
    }

    //说话
    public void test1(Target t) {
        t.handleReq();
    }
}
