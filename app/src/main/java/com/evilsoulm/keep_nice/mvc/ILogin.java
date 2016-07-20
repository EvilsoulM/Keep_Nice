package com.evilsoulm.keep_nice.mvc;

/**
 * Author by mazixuan
 * Data:2016-07-18 23:38
 * Project:Keep_Nice
 * Detail:
 */

public abstract class ILogin {
    protected LoginCallback callBack;

    public ILogin(LoginCallback loginCallBack) {
        callBack = loginCallBack;
    }

    public abstract void login(String name, String pass);

    public abstract String getName();
}
