package com.evilsoulm.keep_nice.patterns.proxy;

/**
 * Author by mazixuan
 * Data:2016-10-25 11:10
 * Project:Keep_Nice
 * Detail:
 */

public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }

    @Override
    public void sing() {
        System.out.println("张学友.sing()");//真实角色的操作：真正的业务逻辑
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}
