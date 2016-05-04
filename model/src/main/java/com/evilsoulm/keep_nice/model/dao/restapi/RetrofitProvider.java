package com.evilsoulm.keep_nice.model.dao.restapi;

/**
 * Author by mazixuan
 * Data:2016-05-04 22:19
 * Project:Keep_Nice
 * Detail:
 */
public class RetrofitProvider {

    private RetrofitProvider() {

    }

    public static RetrofitProvider getInstance() {
        return SingleInstanceHolder.instance;
    }

    private static class SingleInstanceHolder {
        private static RetrofitProvider instance = new RetrofitProvider();
    }

}
