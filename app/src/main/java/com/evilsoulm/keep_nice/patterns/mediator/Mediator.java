package com.evilsoulm.keep_nice.patterns.mediator;

/**
 * Author by mazixuan
 * Data:2016-10-12 23:27
 * Project:Keep_Nice
 * Detail:抽象中介者
 */
public interface Mediator {
    void register(String dname, Department department);

    void command(String dname);
}
