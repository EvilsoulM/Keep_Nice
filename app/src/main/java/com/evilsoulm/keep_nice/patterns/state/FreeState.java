package com.evilsoulm.keep_nice.patterns.state;

/**
 * Author by mazixuan
 * Data:2016-10-13 00:25
 * Project:Keep_Nice
 * Detail:
 */

public class FreeState implements State {
    @Override
    public void handler() {
        System.out.println("房间空闲中，可以预定！");
    }
}
