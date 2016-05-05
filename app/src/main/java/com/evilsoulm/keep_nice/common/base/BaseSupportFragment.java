package com.evilsoulm.keep_nice.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.evilsoulm.keep_nice.R;
import com.evilsoulm.keep_nice.common.KeepApplication;
import com.evilsoulm.keep_nice.common.Navigator;
import com.evilsoulm.keep_nice.dl.components.ApiComponent;
import com.evilsoulm.keep_nice.dl.components.ApplicationComponent;

import butterknife.Bind;
import butterknife.ButterKnife;
import icepick.Icepick;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusSupportFragment;

public abstract class BaseSupportFragment<PresenterType extends Presenter> extends NucleusSupportFragment<PresenterType> {
    @Nullable
    @Bind(R.id.toolbar)
    public Toolbar toolbarView;

    @Nullable
    @Bind(R.id.toolbar_title)
    public TextView toolbarTitleView;

    public Navigator navigator;

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Icepick.saveInstanceState(this, bundle);
    }

    @Override
    public void onCreate(Bundle bundle) {
        injectorPresenter();
        super.onCreate(bundle);
        navigator = getAppComponent().navigator();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        ButterKnife.bind(this, view);

        if (toolbarTitleView != null && !TextUtils.isEmpty(getTitle())) {
            toolbarTitleView.setText(getTitle());
        }
    }

    protected String getTitle() {
        return "";
    }

    protected ApplicationComponent getAppComponent() {
        return ((KeepApplication) getActivity().getApplication()).getApplicationComponent();
    }

    protected ApiComponent getApiComponent() {
        return ((KeepApplication) getActivity().getApplication()).getApiComponent();
    }


    protected void injectorPresenter() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}