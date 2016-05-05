package com.evilsoulm.keep_nice.model.dao.restapi.service;

import com.evilsoulm.keep_nice.model.dao.entity.LastestNewsResponse;

import rx.Observable;

/**
 * Author by mazixuan
 * Data:2016-05-05 13:58
 * Project:Keep_Nice
 * Detail:
 */
public class NewsDataPrvdr extends BaseDataPrvdr<NewsService> {

    public Observable<LastestNewsResponse> getLastestNews() {
        return service.getLastestNews();
    }

    @Override
    protected Class<NewsService> getServiceClass() {
        return NewsService.class;
    }
}
