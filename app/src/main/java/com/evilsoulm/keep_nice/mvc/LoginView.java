package com.evilsoulm.keep_nice.mvc;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.evilsoulm.keep_nice.R;

/**
 * Author by mazixuan
 * Data:2016-07-18 23:16
 * Project:Keep_Nice
 * Detail:
 */

public class LoginView {
    private EditText txtName;
    private EditText txtPass;
    private Button btnLogin;
    private ILoginView loginDelegate;
    private Activity activity;
    private View.OnClickListener onLoginBtnClick = v -> {
        loginDelegate.login(txtName.getText().toString(), txtPass.getText().toString());
    };

    public LoginView(Activity activity, LoginView.ILoginView iLoginView) {
        this.activity = activity;
        loginDelegate = iLoginView;
    }

    public int getViewXml() {
        return R.layout.activity_login;
    }

    public void initView() {
        txtName = (EditText) activity.findViewById(R.id.txt_name);
        txtPass = (EditText) activity.findViewById(R.id.txt_pass);
        btnLogin = (Button) activity.findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(onLoginBtnClick);
    }


    public interface ILoginView {
        void login(String name, String pass);
    }


}
