package com.evilsoulm.keep_nice.patterns.composite;

/**
 * Author by mazixuan
 * Data:2016-10-25 10:51
 * Project:Keep_Nice
 * Detail:
 */

public abstract class Component {
    protected String name;

    public Component(String name) {
        super();
        this.name = name;
    }

    public abstract void add(Component c);

    public abstract void remove(Component c);

    public abstract void display(int depth);
}
