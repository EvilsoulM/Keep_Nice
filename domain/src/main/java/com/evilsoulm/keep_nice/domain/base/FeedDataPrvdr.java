package com.evilsoulm.keep_nice.domain.base;

import com.evilsoulm.keep_nice.model.dao.entity.BaseFeedResponse;
import com.evilsoulm.keep_nice.model.dao.entity.Feed;
import com.evilsoulm.keep_nice.model.dao.restapi.FeedType;
import com.evilsoulm.keep_nice.model.dao.restapi.service.FeedService;

import rx.Observable;

/**
 * Author by EvilsoulM
 * Data:2016-05-06 13:23
 * Project:Keep_Nice
 * Detail:
 */
public class FeedDataPrvdr extends BaseDataPrvdr<FeedService> {
    private static final int BASE_REQUEST_NUM = 20;

    @Override
    protected Class<FeedService> getServiceClass() {
        return FeedService.class;
    }

    public Observable<BaseFeedResponse<Feed>> getAndroidFeed(int page) {
        return service.getFeed(FeedType.ANDROID.getType(), BASE_REQUEST_NUM, page);
    }

    public Observable<BaseFeedResponse<Feed>> getiOSFeed(int page) {
        return service.getFeed(FeedType.IOS.getType(), BASE_REQUEST_NUM, page);
    }

    public Observable<BaseFeedResponse<Feed>> getRestFeed(int page) {
        return service.getFeed(FeedType.REST.getType(), BASE_REQUEST_NUM, page);
    }

    public Observable<BaseFeedResponse<Feed>> getWelfareFeed(int page) {
        return service.getFeed(FeedType.WELFARE.getType(), BASE_REQUEST_NUM, page);
    }

    public Observable<BaseFeedResponse<Feed>> getExpandResourceFeed(int page) {
        return service.getFeed(FeedType.EXPAND_RESOURCES.getType(), BASE_REQUEST_NUM, page);
    }

    public Observable<BaseFeedResponse<Feed>> getFrontEndFeed(int page) {
        return service.getFeed(FeedType.FRONT_END.getType(), BASE_REQUEST_NUM, page);
    }

    public Observable<BaseFeedResponse<Feed>> getRandomFeed(int page) {
        return service.getFeed(FeedType.RANDOM.getType(), BASE_REQUEST_NUM, page);
    }

    public Observable<BaseFeedResponse<Feed>> getAppFeed(int page) {
        return service.getFeed(FeedType.APP.getType(), BASE_REQUEST_NUM, page);
    }
}
