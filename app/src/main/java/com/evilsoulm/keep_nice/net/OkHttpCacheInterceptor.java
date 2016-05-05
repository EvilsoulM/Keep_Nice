package com.evilsoulm.keep_nice.net;

import android.util.Log;

import com.evilsoulm.common.Utils.NetUtils;
import com.evilsoulm.keep_nice.common.KeepApplication;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author by mazixuan
 * Data:2016-05-05 14:34
 * Project:Keep_Nice
 * Detail:
 */
public class OkHttpCacheInterceptor implements okhttp3.Interceptor {
    private static final String TAG = OkHttpCacheInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetUtils.isNetworkReachable(KeepApplication.getApplication())) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Log.w(TAG, "no network");
        }
        Response originalResponse = chain.proceed(request);
        if (NetUtils.isNetworkReachable(KeepApplication.getApplication())) {
            //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
