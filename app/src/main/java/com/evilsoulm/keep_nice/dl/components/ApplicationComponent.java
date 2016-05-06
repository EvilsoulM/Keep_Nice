package com.evilsoulm.keep_nice.dl.components;

import android.content.Context;
import android.view.View;

import com.evilsoulm.keep_nice.common.Navigator;
import com.evilsoulm.keep_nice.dl.modules.ApplicationModule;
import com.evilsoulm.keep_nice.dl.modules.NetModule;
import com.evilsoulm.keep_nice.ui.FeedFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Author by mazixuan
 * Data:2016-05-04 16:05
 * Project:Keep_Nice
 * Detail:
 */
@Singleton
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {
    Context context();

    void inject(FeedFragment feedFragment);

    void inject(View view);

    Navigator navigator();
}
