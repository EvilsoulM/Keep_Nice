package com.evilsoulm.keep_nice.ui.presenter;

import android.os.Bundle;

import com.evilsoulm.keep_nice.common.base.BaseRxPresenter;
import com.evilsoulm.keep_nice.common.transformer.SchedulerTransformer;
import com.evilsoulm.keep_nice.domain.base.FeedDataPrvdr;
import com.evilsoulm.keep_nice.model.dao.entity.BaseFeedResponse;
import com.evilsoulm.keep_nice.ui.FeedFragment;

import javax.inject.Inject;


public class FeedPresenter extends BaseRxPresenter<FeedFragment> {
    private static final int REQUEST_ID = 1;
    protected int pageIndex = 1;
    @Inject
    FeedDataPrvdr feedDataPrvdr;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        restartableLatestCache(REQUEST_ID, ()
                -> feedDataPrvdr.getAndroidFeed(pageIndex).map(BaseFeedResponse::getResults).compose(new SchedulerTransformer<>()), (recommendedFragment, feeds)
                -> recommendedFragment.onChangeItems(feeds, pageIndex), (recommendedFragment, throwable)
                -> recommendedFragment.onNetworkError(throwable, pageIndex));
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
