package com.evilsoulm.keep_nice.common.app;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;


/**
 * Author by mazixuan
 */
public abstract class BaseApplication {
    private Application application;

    public BaseApplication(Application application) {
        this.application = application;
    }

    public Context getApplicationContext() {
        return this.application.getApplicationContext();
    }

    public Context getContext() {
        return this.application.getApplicationContext();
    }

    public Application getApplication() {
        return this.application;
    }

    public abstract void onCreate();

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onTerminate() {
    }

    public void onTrimMemory(int level) {
    }
}
