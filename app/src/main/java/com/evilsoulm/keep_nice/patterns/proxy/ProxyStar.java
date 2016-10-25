package com.evilsoulm.keep_nice.patterns.proxy;

/**
 * Author by mazixuan
 * Data:2016-10-25 11:09
 * Project:Keep_Nice
 * Detail:
 */

public class ProxyStar implements Star {
    private Star star;//真实对象的引用（明星）

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket()");
    }

    @Override
    public void sing() {
        star.sing();//真实对象的操作（明星唱歌）
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney()");
    }
}
