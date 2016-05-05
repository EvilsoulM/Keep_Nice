package com.evilsoulm.keep_nice.model.dao.restapi;

import okhttp3.OkHttpClient;

/**
 * Author by mazixuan
 * Data:2016-05-05 11:28
 * Project:Keep_Nice
 * Detail:
 */
public interface OkHttpClientProvider {
    OkHttpClient getHttpClient();
}
