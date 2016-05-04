package com.evilsoulm.keep_nice.dl.components;

import android.content.Context;

import com.evilsoulm.keep_nice.dl.modules.ApplicationModule;
import com.evilsoulm.keep_nice.view.DaggerActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Author by mazixuan
 * Data:2016-05-04 16:05
 * Project:Keep_Nice
 * Detail:
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(DaggerActivity baseActivity);

    Context context();
}
