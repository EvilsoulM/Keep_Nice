package com.evilsoulm.keep_nice.patterns.facade;

/**
 * Author by mazixuan
 * Data:2016-10-25 11:02
 * Project:Keep_Nice
 * Detail:http://www.cnblogs.com/meet/p/5116447.html
 */

public class Facade {

    //所有子系统的引用
    private SubSystemClass s1 = null;
    private SubSystemClass2 s2 = null;
    private SubSystemClass3 s3 = null;

    //构造子系统的引用
    public Facade() {
        this.s1 = new SubSystemClass();
        this.s2 = new SubSystemClass2();
        this.s3 = new SubSystemClass3();
    }

    public void facade() {
        s1.methodOne();
        s2.methodTwo();
        s3.methodThree();
    }
}
