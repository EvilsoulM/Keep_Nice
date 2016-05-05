package com.evilsoulm.keep_nice.domain;

import com.evilsoulm.keep_nice.domain.base.BaseUseCase;
import com.evilsoulm.keep_nice.model.dao.entity.CollectionResponse;
import com.evilsoulm.keep_nice.model.dao.restapi.service.NewsDataPrvdr;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Author by mazixuan
 * Data:2016-05-05 14:00
 * Project:Keep_Nice
 * Detail:
 */
public class NewsUseCaseImp extends BaseUseCase<NewsDataPrvdr> implements NewsUseCase {

    @Override
    public Call requestlastestNews(Callback<CollectionResponse> callback) {
        Call<CollectionResponse> call = prvdr.getLastestNews();
        call.enqueue(callback);
        return call;
    }

    @Override
    public NewsDataPrvdr getPrvdr() {
        return new NewsDataPrvdr();
    }
}
