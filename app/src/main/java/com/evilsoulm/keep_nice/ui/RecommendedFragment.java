package com.evilsoulm.keep_nice.ui;

import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.evilsoulm.keep_nice.R;
import com.evilsoulm.keep_nice.common.base.LazyFragment;
import com.evilsoulm.keep_nice.common.qualifier.ClickType;
import com.evilsoulm.keep_nice.model.dao.entity.LastestNewsResponse;
import com.evilsoulm.keep_nice.model.dao.entity.News;
import com.evilsoulm.keep_nice.ui.presenter.RecommendedPresenter;
import com.evilsoulm.keep_nice.ui.view.TopicItemView;
import com.kennyc.view.MultiStateView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import io.nlopez.smartadapters.SmartAdapter;
import io.nlopez.smartadapters.adapters.RecyclerMultiAdapter;
import io.nlopez.smartadapters.utils.ViewEventListener;
import nucleus.factory.PresenterFactory;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(RecommendedPresenter.class)
public class RecommendedFragment extends LazyFragment<RecommendedPresenter> implements
        ViewEventListener<News> {
    RecyclerMultiAdapter adapter;
    @Bind(R.id.multiStateView)
    MultiStateView multiStateView;
    @Bind(R.id.refresh)
    MaterialRefreshLayout refreshView;
    @Bind(R.id.recycler_view)
    RecyclerView topicListView;
    @Inject
    AccountManager accountManager;
    private boolean isPrepared;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getAppComponent().inject(this);
    }

    @Override
    protected void injectorPresenter() {
        super.injectorPresenter();
        final PresenterFactory<RecommendedPresenter> superFactory = super.getPresenterFactory();
        setPresenterFactory(() -> {
            RecommendedPresenter presenter = superFactory.createPresenter();
            getApiComponent().inject(presenter);
            return presenter;
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.topic_normal_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (toolbarView != null) {
            toolbarView.inflateMenu(R.menu.menu_publish);
            toolbarView.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
//                    navigator.navigateToPublishTopic(getContext());
                    return true;
                }
            });
        }

        topicListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = SmartAdapter.empty()
                .map(News.class, TopicItemView.class)
                .listener(this)
                .into(topicListView);

        refreshView.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                getPresenter().refresh();
            }

            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                getPresenter().nextPage();
            }
        });

        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }

        if (!canLoadData(multiStateView, adapter)) {
            return;
        }

        multiStateView.setViewState((MultiStateView.VIEW_STATE_LOADING));
        refreshView.autoRefresh();
    }

    @Override
    public void onResume() {
        super.onResume();
        Menu menu = toolbarView.getMenu();
//        if (menu != null) {
//            MenuItem publishView = menu.findItem(R.id.action_publish);
//            if (publishView != null) {
//                publishView.setVisible(false);
//            }
//        }
    }

    @Override
    protected String getTitle() {
        return getString(R.string.recommended);
    }

    public void onChangeItems(LastestNewsResponse response, int pageIndex) {
        if (pageIndex == 1) {
            adapter.setItems(response.getStories());
            multiStateView.setViewState((MultiStateView.VIEW_STATE_CONTENT));
            refreshView.finishRefresh();
        } else {
            adapter.addItems(response.getStories());
            refreshView.finishRefreshLoadMore();
        }
    }

    public void onNetworkError(Throwable throwable, int pageIndex) {
//        Logger.e(throwable.getMessage());
        if (pageIndex == 1) {
            multiStateView.setViewState((MultiStateView.VIEW_STATE_ERROR));
        }
    }

    @OnClick(R.id.retry)
    public void retry() {
        multiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
        getPresenter().refresh();
    }

    @Override
    public void onViewEvent(int i, News news, int i1, View view) {

        switch (i) {
            case ClickType.CLICK_TYPE_TOPIC_CLICKED:
//                navigator.navigateToTopicDetails(getActivity(), topic.getId());
                break;

            case ClickType.CLICK_TYPE_USER_CLICKED:
//                navigator.navigateToUserSpace(getContext(), userInfo.getId());
                break;
        }
    }
}