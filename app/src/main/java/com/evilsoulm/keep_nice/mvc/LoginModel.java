package com.evilsoulm.keep_nice.mvc;

import android.text.TextUtils;

/**
 * Author by mazixuan
 * Data:2016-07-18 23:26
 * Project:Keep_Nice
 * Detail:
 */

public class LoginModel extends ILogin {

    public LoginModel(LoginCallback loginCallBack) {
        super(loginCallBack);
    }

    @Override
    public void login(String name, String pass) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pass)) {
            callBack.loginFail();
        } else {
            callBack.loginSuc();
        }
    }

    @Override
    public String getName() {
        return "LoginModel";
    }


}
