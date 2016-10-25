package com.evilsoulm.keep_nice.patterns.mediator;

/**
 * Author by mazixuan
 * Data:2016-10-12 23:35
 * Project:Keep_Nice
 * Detail:
 */

public class Development implements Department {
    private Mediator mMediator;

    public Development(Mediator mMediator) {
        this.mMediator = mMediator;
        mMediator.register("development", this);
    }

    @Override
    public void selfAction() {
        System.out.println("研发部 self");
    }

    @Override
    public void outAction() {
        System.out.println("研发部向上级说 self");
    }
}
