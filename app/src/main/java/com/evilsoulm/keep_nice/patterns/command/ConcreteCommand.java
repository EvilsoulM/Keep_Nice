package com.evilsoulm.keep_nice.patterns.command;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:10
 * Project:Keep_Nice
 * Detail:
 */

public class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
