package com.evilsoulm.keep_nice.patterns.command;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:22
 * Project:Keep_Nice
 * Detail:
 */

public class Demo {
    public static void main(String[] args) {
        //通过请求者（invoker）调用命令对象（command），命令对象中调用了命令具体执行者（Receiver）
        Command command = new ConcreteCommand(new Receiver());
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}
