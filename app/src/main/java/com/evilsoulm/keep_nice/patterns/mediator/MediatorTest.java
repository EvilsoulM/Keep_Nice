package com.evilsoulm.keep_nice.patterns.mediator;

/**
 * Author by mazixuan
 * Data:2016-10-12 23:41
 * Project:Keep_Nice
 * Detail:
 */

public class MediatorTest {

    public static void main(String[] args) {
        Mediator mediator = new President();
        Finacial finacial = new Finacial(mediator);
        Market market = new Market(mediator);
        market.selfAction();
        market.outAction();
    }
}
