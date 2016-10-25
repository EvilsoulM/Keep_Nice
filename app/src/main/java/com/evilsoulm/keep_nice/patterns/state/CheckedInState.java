package com.evilsoulm.keep_nice.patterns.state;

/**
 * Author by mazixuan
 * Data:2016-10-13 00:26
 * Project:Keep_Nice
 * Detail:
 */

public class CheckedInState implements State {
    @Override
    public void handler() {
        System.out.println("房间已入住！");
    }
}
