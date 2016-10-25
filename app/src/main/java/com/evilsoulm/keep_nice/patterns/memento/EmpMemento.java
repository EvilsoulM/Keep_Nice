package com.evilsoulm.keep_nice.patterns.memento;

/**
 * Author by mazixuan
 * Data:2016-10-13 00:01
 * Project:Keep_Nice
 * Detail:
 */

public class EmpMemento {
    //自身属性
    private String ename;
    private int age;
    private double salary;

    //构造备忘录对象时，需要传入一个需要备忘的对象（发起人）
    public EmpMemento(EmpOriginator emp) {
        this.ename = emp.getEname();
        this.age = emp.getAge();
        this.salary = emp.getSalary();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
