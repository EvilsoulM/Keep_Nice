package com.evilsoulm.keep_nice.common.app;

import android.app.Application;
import android.util.Log;

import com.evilsoulm.keep_nice.model.dao.restapi.RetrofitProvider;
import com.evilsoulm.keep_nice.net.OkHttpCacheInterceptor;
import com.evilsoulm.keep_nice.net.OkhttpLoggingInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Author by mazixuan
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
        RetrofitProvider.init(getOkHttp());
    }

    public OkHttpClient getOkHttp() {
        OkHttpClient.Builder client = new OkHttpClient().newBuilder();
        OkHttpCacheInterceptor okHttpCacheInterceptor = new OkHttpCacheInterceptor();

        client.networkInterceptors().add(okHttpCacheInterceptor);
        client.interceptors().add(okHttpCacheInterceptor);
        client.interceptors().add(new OkhttpLoggingInterceptor());
        client.connectTimeout(30, TimeUnit.SECONDS);
        client.readTimeout(30, TimeUnit.SECONDS);
        client.writeTimeout(30, TimeUnit.SECONDS);

        //设置缓存
        File httpCacheDirectory = new File(getContext().getCacheDir(), "responses");

        Cache cache = null;
        try {
            cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
        } catch (Exception e) {
            Log.e("OKHttp", "Could not create http cache", e);
        }

        if (cache != null) {
            client.cache(cache);
        }

        return client.build();
    }
}
