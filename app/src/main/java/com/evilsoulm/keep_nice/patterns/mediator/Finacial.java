package com.evilsoulm.keep_nice.patterns.mediator;

/**
 * Author by mazixuan
 * Data:2016-10-12 23:37
 * Project:Keep_Nice
 * Detail:
 */

public class Finacial implements Department {
    private Mediator mMediator;

    public Finacial(Mediator mMediator) {
        this.mMediator = mMediator;
        mMediator.register(this.getClass().getSimpleName(), this);
    }

    @Override
    public void selfAction() {
        System.out.println("财务部 self");
    }

    @Override
    public void outAction() {
        System.out.println("财务部向上级说 self");
    }
}
