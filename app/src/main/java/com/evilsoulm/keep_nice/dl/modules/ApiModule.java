package com.evilsoulm.keep_nice.dl.modules;

import com.evilsoulm.keep_nice.model.dao.restapi.service.NewsDataPrvdr;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ApplicationModule.class)
public class ApiModule {

    @Provides
    @Singleton
    NewsDataPrvdr provideNewsDataPrvdr() {
        return new NewsDataPrvdr();
    }
}