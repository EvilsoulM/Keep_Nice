package com.evilsoulm.keep_nice.model.dao.restapi.service;

import com.evilsoulm.keep_nice.model.dao.entity.BaseFeedResponse;
import com.evilsoulm.keep_nice.model.dao.entity.Feed;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Author by EvilsoulM
 * Data:2016-05-06 13:19
 * Project:Keep_Nice
 * Detail:
 */
public interface FeedService {
    @Headers("Cache-Control: public, max-age=60")
    @GET("{type}/{requestNum}/{page}")
    Observable<BaseFeedResponse<Feed>> getFeed(@Path("type") String type, @Path("requestNum") int requestNum, @Path("page") int page);
}
