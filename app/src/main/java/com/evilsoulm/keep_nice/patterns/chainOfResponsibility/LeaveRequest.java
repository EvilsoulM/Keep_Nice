package com.evilsoulm.keep_nice.patterns.chainOfResponsibility;

/**
 * Author by mazixuan
 * Data:2016-10-24 19:41
 * Project:Keep_Nice
 * Detail:
 */

public class LeaveRequest {
    private String empName;
    private int leaveDays;
    private String reason;

    public LeaveRequest(String empName, int leaveDays, String reason) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.reason = reason;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

