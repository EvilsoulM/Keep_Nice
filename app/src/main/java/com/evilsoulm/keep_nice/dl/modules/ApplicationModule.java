package com.evilsoulm.keep_nice.dl.modules;

import android.content.Context;

import com.evilsoulm.keep_nice.common.KeepApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Author by EvilsoulM
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
}
