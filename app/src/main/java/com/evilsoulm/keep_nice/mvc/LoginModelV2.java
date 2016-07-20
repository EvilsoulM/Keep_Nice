package com.evilsoulm.keep_nice.mvc;

import android.text.TextUtils;

/**
 * Author by mazixuan
 * Data:2016-07-18 23:43
 * Project:Keep_Nice
 * Detail:
 */

public class LoginModelV2 extends ILogin {
    public LoginModelV2(LoginCallback loginCallBack) {
        super(loginCallBack);
    }

    @Override
    public void login(String name, String pass) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass)) {
            callBack.loginSuc();
            //request/
        } else {
            callBack.loginFail();
        }
    }

    @Override
    public String getName() {
        return "LoginModelV2";
    }
}
