package com.evilsoulm.keep_nice.model.dao.restapi.service;

import com.evilsoulm.keep_nice.model.dao.entity.CollectionResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Author by mazixuan
 * Data:2016-05-05 13:57
 * Project:Keep_Nice
 * Detail:
 */
public interface NewsService {
    @GET("/news/latest")
    Call<CollectionResponse> getLastestNews();
}
