package com.evilsoulm.keep_nice.ui.presenter;

import android.content.Intent;
import android.net.Uri;

import com.evilsoulm.common.Utils.AndroidUtil;
import com.evilsoulm.keep_nice.common.base.BaseRxPresenter;
import com.evilsoulm.keep_nice.ui.view.activity.WebViewActivity;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * Author by mazixuan
 * Data:2016-05-09 11:32
 * Project:Keep_Nice
 * Detail:
 */
public class WebViewPresenter extends BaseRxPresenter<WebViewActivity> {

    public void setWebViewSettings(com.tencent.smtt.sdk.WebView webView, String url) {
        com.tencent.smtt.sdk.WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setAppCacheEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);
        settings.setBlockNetworkImage(true);
        webView.setWebChromeClient(new ChromeClient());
        webView.setWebViewClient(new KeepWebViewClient());
        webView.loadUrl(url);
    }

    public void refresh(WebView webView) {
        webView.reload();
    }

    public void copyUrl(String text) {
        if (getView() != null) {
            AndroidUtil.copyToClipBoard(getView().getApplicationContext(), text, "复制成功");
        }
    }

    public void openInBrowser(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse(url);
        intent.setData(uri);

        if (getView() == null) {
            return;
        }

        if (intent.resolveActivity(getView().getPackageManager()) != null) {
            getView().startActivity(intent);
        } else {
            getView().openFailed();
        }
    }


    private class ChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (getView() != null) {
                getView().showProgressBar(newProgress);
            }
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (getView() != null) {
                getView().setWebTitle(title);
            }
        }
    }

    private class KeepWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url != null) view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.getSettings().setBlockNetworkImage(false);
        }
    }
}
