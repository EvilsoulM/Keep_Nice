package com.evilsoulm.keep_nice.domain;

import com.evilsoulm.keep_nice.model.dao.entity.CollectionResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Author by mazixuan
 * Data:2016-05-05 13:59
 * Project:Keep_Nice
 * Detail:
 */
public interface NewsUseCase {
    Call requestlastestNews(Callback<CollectionResponse> callback);
}
