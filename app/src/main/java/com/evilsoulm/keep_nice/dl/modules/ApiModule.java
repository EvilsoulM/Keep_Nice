package com.evilsoulm.keep_nice.dl.modules;

import com.evilsoulm.keep_nice.domain.base.FeedDataPrvdr;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApplicationModule.class)
public class ApiModule {

    @Provides
    @Singleton
    FeedDataPrvdr provideFeedDataPrvdr() {
        return new FeedDataPrvdr();
    }
}