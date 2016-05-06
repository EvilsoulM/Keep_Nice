package com.evilsoulm.keep_nice.common.app;

import android.app.Application;

import com.evilsoulm.keep_nice.common.KeepApplication;
import com.evilsoulm.keep_nice.model.dao.restapi.RetrofitProvider;

/**
 * Author by EvilsoulM
 * Data:2016-05-04 11:21
 * Project:Keep_Nice
 * Detail:
 */
public class KeepMainProcessApplication extends BaseApplication {
    public KeepMainProcessApplication(Application application) {
        super(application);
    }

    @Override
    public void onCreate() {
        RetrofitProvider.init(KeepApplication.getApplication().getApplicationComponent().okhttpClient());
    }


}
