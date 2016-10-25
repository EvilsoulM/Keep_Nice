package com.evilsoulm.keep_nice.patterns.strategy;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:37
 * Project:Keep_Nice
 * Detail:
 */

public class Demo {
    public static void main(String[] args) {
        double price = 998;//商品价格
        Strategty generalUser = new GeneralUser();//普通用户
        Strategty registerUser = new RegisterUser();//注册用户
        Strategty registerVip = new RegisterVip();//普通会员
//        Strategty oldVip = new OldVip();//老会员

        //根据不同的用户打不同的折扣
        Context c1 = new Context(generalUser);
        c1.printPrice(price);
        Context c2 = new Context(registerUser);
        c2.printPrice(price);
        Context c3 = new Context(registerVip);
        c3.printPrice(price);
//        Context c4 = new Context(oldVip);
//        c4.printPrice(price);
    }
}
