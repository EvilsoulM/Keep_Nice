package com.evilsoulm.keep_nice.dl.modules;

import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;

import com.bumptech.glide.Glide;
import com.evilsoulm.keep_nice.common.ImageLoader;
import com.evilsoulm.keep_nice.net.OkHttpCacheInterceptor;
import com.evilsoulm.keep_nice.net.OkhttpLoggingInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

@Module
public class NetModule {

    @Provides
    @Singleton
    ImageLoader provideImageLoader(Application movieProApplication) {
        return new ImageLoader(Glide.with(movieProApplication));
    }

    @Provides
    @Singleton
    AccountManager provideAccountManager(Context context) {
        return AccountManager.get(context);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttp(Context context, Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
        OkHttpCacheInterceptor okHttpCacheInterceptor = new OkHttpCacheInterceptor();

        client.networkInterceptors().add(okHttpCacheInterceptor);
        client.interceptors().add(okHttpCacheInterceptor);
        client.interceptors().add(new OkhttpLoggingInterceptor());
        client.connectTimeout(30, TimeUnit.SECONDS);
        client.readTimeout(30, TimeUnit.SECONDS);
        client.writeTimeout(30, TimeUnit.SECONDS);

        if (cache != null) {
            client.cache(cache);
        }

        return client.build();
    }

    @Provides
    @Singleton
    Cache provideCache(Context context) {

        //设置缓存
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");

        Cache cache = null;
        try {
            cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cache;
    }
}
