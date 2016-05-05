package com.evilsoulm.keep_nice.model.dao.restapi.service;

import com.evilsoulm.keep_nice.model.dao.entity.LastestNewsResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Author by mazixuan
 * Data:2016-05-05 13:57
 * Project:Keep_Nice
 * Detail:
 */
public interface NewsService {
    @GET("api/4/news/latest")
    Observable<LastestNewsResponse> getLastestNews();
}
