package com.evilsoulm.keep_nice.patterns.chainOfResponsibility;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:42
 * Project:Keep_Nice
 * Detail:
 */

public abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public abstract void handleRequest(LeaveRequest request);
}
