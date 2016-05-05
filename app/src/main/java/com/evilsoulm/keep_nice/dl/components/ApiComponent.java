package com.evilsoulm.keep_nice.dl.components;


import com.evilsoulm.keep_nice.dl.modules.ApiModule;
import com.evilsoulm.keep_nice.ui.presenter.RecommendedPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {
    void inject(RecommendedPresenter recommendedPresenter);
}