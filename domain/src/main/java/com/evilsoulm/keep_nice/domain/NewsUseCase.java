package com.evilsoulm.keep_nice.domain;

import com.evilsoulm.keep_nice.model.dao.entity.LastestNewsResponse;

import retrofit2.Callback;
import rx.Observable;

/**
 * Author by mazixuan
 * Data:2016-05-05 13:59
 * Project:Keep_Nice
 * Detail:
 */
public interface NewsUseCase {
    Observable requestlastestNews(Callback<LastestNewsResponse> callback);
}
