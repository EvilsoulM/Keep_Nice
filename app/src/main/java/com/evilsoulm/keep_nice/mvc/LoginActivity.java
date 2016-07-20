package com.evilsoulm.keep_nice.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Author by mazixuan
 * Data:2016-07-18 23:13
 * Project:Keep_Nice
 * Detail:
 */
public class LoginActivity extends Activity implements LoginView.ILoginView, LoginCallback {

    private LoginView loginView;
    private ILogin model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginView = new LoginView(this, this);
        setContentView(loginView.getViewXml());
        loginView.initView();
        model = new LoginModel(this);
        loginView.setName(model.getName());
    }

    @Override
    public void login(String name, String pass) {
        model.login(name, pass);
    }

    @Override
    public void loginSuc() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }
}
