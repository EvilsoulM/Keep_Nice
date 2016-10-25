package com.evilsoulm.keep_nice.patterns.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by mazixuan
 * Data:2016-10-12 23:39
 * Project:Keep_Nice
 * Detail:
 */

public class President implements Mediator {

    private Map<String, Department> map = new HashMap<String, Department>();

    @Override
    public void register(String dname, Department department) {
        map.put(dname, department);//将同事注册到总经理的所有同事类容器中
    }

    @Override
    public void command(String dname) {
        map.get(dname).selfAction();//根据部门名称向具体的部门下命令
    }
}
