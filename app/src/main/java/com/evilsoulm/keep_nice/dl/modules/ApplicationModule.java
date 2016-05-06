package com.evilsoulm.keep_nice.dl.modules;

import android.accounts.AccountManager;
import android.content.Context;

import com.evilsoulm.keep_nice.common.KeepApplication;
import com.evilsoulm.keep_nice.net.OkHttpCacheInterceptor;
import com.evilsoulm.keep_nice.net.OkhttpLoggingInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

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

    @Provides
    @Singleton
    OkHttpClient provideOkhttp(Context context) {
        return getOkHttp(context);
    }

    private OkHttpClient getOkHttp(Context context) {
        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
        OkHttpCacheInterceptor okHttpCacheInterceptor = new OkHttpCacheInterceptor();

        client.networkInterceptors().add(okHttpCacheInterceptor);
        client.interceptors().add(okHttpCacheInterceptor);
        client.interceptors().add(new OkhttpLoggingInterceptor());
        client.connectTimeout(30, TimeUnit.SECONDS);
        client.readTimeout(30, TimeUnit.SECONDS);
        client.writeTimeout(30, TimeUnit.SECONDS);

        //设置缓存
        File httpCacheDirectory = new File(context.getCacheDir(), "responses");

        Cache cache = null;
        try {
            cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (cache != null) {
            client.cache(cache);
        }

        return client.build();
    }
}
