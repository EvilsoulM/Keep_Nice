package com.evilsoulm.keep_nice.dl.modules;

import android.accounts.AccountManager;
import android.content.Context;

import com.evilsoulm.keep_nice.common.KeepApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Author by mazixuan
 * Data:2016-05-04 16:10
 * Project:Keep_Nice
 * Detail:
 */
@Module
public class ApplicationModule {
    private final KeepApplication application;

    public ApplicationModule(KeepApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    AccountManager provideAccountManager(Context context) {
        return AccountManager.get(context);
    }
}
