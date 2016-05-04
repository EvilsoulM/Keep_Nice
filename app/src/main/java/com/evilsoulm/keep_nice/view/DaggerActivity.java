package com.evilsoulm.keep_nice.view;

import android.app.Activity;
import android.os.Bundle;

import com.evilsoulm.keep_nice.KeepApplication;
import com.evilsoulm.keep_nice.dl.components.ApplicationComponent;
import com.evilsoulm.keep_nice.dl.modules.ActivityModule;

/**
 * Author by mazixuan
 * Data:2016-05-04 16:06
 * Project:Keep_Nice
 * Detail:
 */
public abstract class DaggerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((KeepApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
