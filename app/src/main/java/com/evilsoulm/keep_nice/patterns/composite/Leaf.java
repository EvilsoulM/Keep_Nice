package com.evilsoulm.keep_nice.patterns.composite;

/**
 * Author by mazixuan
 * Data:2016-10-25 10:53
 * Project:Keep_Nice
 * Detail:
 */

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        System.out.println("leaf no add");
    }

    @Override
    public void remove(Component c) {
        System.out.println("leaf no remove");
    }

    @Override
    public void display(int depth) {
        StringBuffer sb = new StringBuffer("-");
        for (int i = 0; i <= depth; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString() + name);
    }
}
