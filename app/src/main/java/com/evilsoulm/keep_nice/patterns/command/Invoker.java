package com.evilsoulm.keep_nice.patterns.command;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:20
 * Project:Keep_Nice
 * Detail:
 */

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}
