package com.evilsoulm.keep_nice.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.evilsoulm.keep_nice.R;
import com.evilsoulm.keep_nice.common.base.BaseActivity;
import com.evilsoulm.keep_nice.common.parser.ViewBinder;
import com.evilsoulm.keep_nice.common.parser.ViewBinderParser;
import com.evilsoulm.keep_nice.model.dao.entity.Feed;
import com.evilsoulm.keep_nice.ui.presenter.WebViewPresenter;
import com.evilsoulm.keep_nice.ui.view.listener.IWebView;
import com.tencent.smtt.sdk.WebView;

import butterknife.Bind;
import nucleus.factory.PresenterFactory;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(WebViewPresenter.class)
public class WebViewActivity extends BaseActivity<WebViewPresenter> implements IWebView {
    private static final String BUNDLE_FEED = "bd_feed";
    @Bind(R.id.web_view)
    WebView webView;
    @Bind(R.id.progressbar)
    NumberProgressBar progressbar;
    @ViewBinder(id = R.id.bottom)
    View view;

    private Feed feed;

    public static Intent getCallingIntent(Context context, Feed feed) {
        Intent callingIntent = new Intent(context, WebViewActivity.class);
        callingIntent.putExtra(BUNDLE_FEED, feed);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        feed = (Feed) getIntent().getSerializableExtra(BUNDLE_FEED);
        getPresenter().setWebViewSettings(webView, feed.url.get());
        setWebTitle(feed.desc.get());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void injectorPresenter() {
        super.injectorPresenter();
        final PresenterFactory<WebViewPresenter> superFactory = super.getPresenterFactory();
        setPresenterFactory(() -> {
            WebViewPresenter presenter = superFactory.createPresenter();
            getApiComponent().inject(presenter);

            return presenter;
        });
    }

    @Override
    public void showProgressBar(int progress) {
        if (progressbar == null) return;
        progressbar.setProgress(progress);
        if (progress == 100) {
            progressbar.setVisibility(View.GONE);
        } else {
            progressbar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setWebTitle(String title) {
        setTitle(title);
    }

    @Override
    public void openFailed() {
        Toast.makeText(this, "打开失败", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                getPresenter().refresh(webView);
                break;
            case R.id.action_copy_url:
                getPresenter().copyUrl(webView.getUrl());
                break;
            case R.id.action_open_in_browser:
                getPresenter().openInBrowser(webView.getUrl());
                break;
            case R.id.action_share_gank:
                ViewBinderParser.inject(WebViewActivity.this);
                Log.i("tag", view.getHeight() + " ####");
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
