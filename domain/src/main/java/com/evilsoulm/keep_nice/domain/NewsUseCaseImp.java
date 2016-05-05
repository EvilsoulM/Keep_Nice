package com.evilsoulm.keep_nice.domain;

import com.evilsoulm.keep_nice.domain.base.BaseUseCase;
import com.evilsoulm.keep_nice.model.dao.entity.LastestNewsResponse;
import com.evilsoulm.keep_nice.model.dao.restapi.service.NewsDataPrvdr;

import retrofit2.Callback;
import rx.Observable;

/**
 * Author by mazixuan
 * Data:2016-05-05 14:00
 * Project:Keep_Nice
 * Detail:
 */
public class NewsUseCaseImp extends BaseUseCase<NewsDataPrvdr> implements NewsUseCase {

    @Override
    public Observable requestlastestNews(Callback<LastestNewsResponse> callback) {
        return prvdr.getLastestNews();
    }

    @Override
    public NewsDataPrvdr getPrvdr() {
        return new NewsDataPrvdr();
    }
}
