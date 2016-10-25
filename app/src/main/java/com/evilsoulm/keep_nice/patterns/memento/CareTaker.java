package com.evilsoulm.keep_nice.patterns.memento;

/**
 * Author by mazixuan
 * Data:2016-10-13 00:04
 * Project:Keep_Nice
 * Detail:
 */

public class CareTaker {
    private EmpMemento empMemento;

    public EmpMemento getEmpMemento() {
        return empMemento;
    }

    public void setEmpMemento(EmpMemento empMemento) {
        this.empMemento = empMemento;
    }
}
