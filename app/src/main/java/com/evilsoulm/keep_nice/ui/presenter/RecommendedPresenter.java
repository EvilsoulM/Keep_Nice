package com.evilsoulm.keep_nice.ui.presenter;

import android.os.Bundle;

import com.evilsoulm.keep_nice.common.base.BaseRxPresenter;
import com.evilsoulm.keep_nice.common.transformer.SchedulerTransformer;
import com.evilsoulm.keep_nice.model.dao.restapi.service.NewsDataPrvdr;
import com.evilsoulm.keep_nice.ui.RecommendedFragment;

import javax.inject.Inject;


public class RecommendedPresenter extends BaseRxPresenter<RecommendedFragment> {
    private static final int REQUEST_ID = 1;
    protected int pageIndex = 1;
    @Inject
    NewsDataPrvdr newsDataPrvdr;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        restartableLatestCache(REQUEST_ID,
                () -> newsDataPrvdr.getLastestNews().compose(new SchedulerTransformer<>()),
                (recommendedFragment, topics) -> recommendedFragment.onChangeItems(topics, pageIndex),
                (recommendedFragment, throwable) -> recommendedFragment.onNetworkError(throwable, pageIndex));
    }

    public void refresh() {
        pageIndex = 1;
        start(REQUEST_ID);
    }

    public void nextPage() {
        pageIndex++;
        start(REQUEST_ID);
    }
}
