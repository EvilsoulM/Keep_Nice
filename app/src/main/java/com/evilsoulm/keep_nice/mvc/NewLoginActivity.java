package com.evilsoulm.keep_nice.mvc;

import android.app.Activity;
import android.os.Bundle;

/**
 * Author by mazixuan
 * Data:2016-07-19 20:02
 * Project:Keep_Nice
 * Detail:
 */

public class NewLoginActivity extends Activity implements LoginView.ILoginView {
    private LoginView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginView = new LoginView(this, this);
        setContentView(loginView.getViewXml());
    }

    @Override
    public void login(String name, String pass) {

    }
}
