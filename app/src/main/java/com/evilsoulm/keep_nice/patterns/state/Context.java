package com.evilsoulm.keep_nice.patterns.state;

/**
 * Author by mazixuan
 * Data:2016-10-13 00:26
 * Project:Keep_Nice
 * Detail:
 */

public class Context {
    private State state;

    public void request(State state) {
        System.out.print("修改状态：");
        this.state = state;
        state.handler();
    }
}
