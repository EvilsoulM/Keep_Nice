package com.evilsoulm.keep_nice.net;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author by mazixuan
 * Data:2016-05-05 14:38
 * Project:Keep_Nice
 * Detail:
 */
public class OkhttpLoggingInterceptor implements Interceptor {
    private static final String TAG = OkhttpLoggingInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        Log.w(TAG, String.format("Sending request %s on %s%n%s", request.url(), chain.connection(), request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Log.w(TAG, String.format("Received response for %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, response.headers()));
        return response;
    }
}
