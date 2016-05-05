package com.evilsoulm.keep_nice.model.dao.restapi.service;

import com.evilsoulm.keep_nice.model.dao.entity.CollectionResponse;

import retrofit2.Call;

/**
 * Author by mazixuan
 * Data:2016-05-05 13:58
 * Project:Keep_Nice
 * Detail:
 */
public class NewsDataPrvdr extends BaseDataPrvdr<NewsService> {

    public Call<CollectionResponse> getLastestNews() {
        return service.getLastestNews();
    }

    @Override
    protected Class<NewsService> getServiceClass() {
        return NewsService.class;
    }
}
