package com.evilsoulm.keep_nice.patterns.chainOfResponsibility;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:56
 * Project:Keep_Nice
 * Detail:
 */

public class Demo {
    public static void main(String[] args) {
        Leader a = new Director("高飞");
        Leader b = new Manager("小虎");
        Leader c = new GeneralManager("CEO");

        a.setNextLeader(b);
        b.setNextLeader(c);

        LeaveRequest request = new LeaveRequest("EvilsoulM", 6, "旅游");
        a.handleRequest(request);
    }
}
