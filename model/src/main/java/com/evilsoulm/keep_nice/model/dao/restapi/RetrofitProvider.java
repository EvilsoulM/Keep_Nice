package com.evilsoulm.keep_nice.model.dao.restapi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author by mazixuan
 * Data:2016-05-04 22:19
 * Project:Keep_Nice
 * Detail:
 */
public class RetrofitProvider {

    private static Retrofit retrofit;

    public static void init(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.baseUrl(ApiConst.BASE_URL);
        builder.client(okHttpClient);
        retrofit = builder.build();
    }

    public static <T> T createService(Class<T> clz) {
        if (retrofit == null) {
            throw new NullPointerException("RetrofitProvider is not init !");
        }
        return (retrofit.create(clz));
    }

}
