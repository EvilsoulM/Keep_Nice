package com.evilsoulm.keep_nice.patterns.memento;

/**
 * Author by mazixuan
 * Data:2016-10-13 00:01
 * Project:Keep_Nice
 * Detail:
 */

public class EmpOriginator {
    private String ename;
    private int age;
    private double salary;

    public EmpOriginator(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    public void recovery(EmpMemento emp) {
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
