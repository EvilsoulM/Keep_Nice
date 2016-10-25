package com.evilsoulm.keep_nice.patterns.mediator;

/**
 * Author by mazixuan
 * Data:2016-10-12 23:28
 * Project:Keep_Nice
 * Detail:
 */

public interface Department {
    void selfAction();//向本部门做的事情

    void outAction();//向总经理申请
}
