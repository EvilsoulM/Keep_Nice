package com.evilsoulm.keep_nice.dl.modules;

import android.app.Application;

import com.bumptech.glide.Glide;
import com.evilsoulm.keep_nice.common.ImageLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gaofei on 15-11-12.
 */
@Module
public class NetModule {

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Application movieProApplication) {
        return new ImageLoader(Glide.with(movieProApplication));
    }
}
