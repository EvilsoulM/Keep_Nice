package com.evilsoulm.keep_nice.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Author by mazixuan
 * Data:2016-10-25 10:57
 * Project:Keep_Nice
 * Detail:
 */

public class Composite extends Component {
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component c) {
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        children.remove(c);
    }

    @Override
    public void display(int depth) {
        StringBuffer sb = new StringBuffer("-");
        for (int i = 0; i <= depth; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString() + name);
        for (Component com : children) {
            com.display(depth + 2);
        }
    }
}
