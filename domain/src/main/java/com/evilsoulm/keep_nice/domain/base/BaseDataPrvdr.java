package com.evilsoulm.keep_nice.domain.base;

import com.evilsoulm.keep_nice.model.dao.restapi.RetrofitProvider;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author by EvilsoulM
 * Data:2016-05-05 13:02
 * Project:Keep_Nice
 * Detail:
 */
public abstract class BaseDataPrvdr<Service> {
    protected Service service;

    public BaseDataPrvdr() {
        service = RetrofitProvider.createService(getServiceClass());
    }

    protected <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    protected abstract Class<Service> getServiceClass();
}
