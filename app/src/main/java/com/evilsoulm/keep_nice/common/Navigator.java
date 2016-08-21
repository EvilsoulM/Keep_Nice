package com.evilsoulm.keep_nice.common;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.evilsoulm.keep_nice.model.dao.entity.Feed;
import com.evilsoulm.keep_nice.ui.view.activity.BindViewActivity;
import com.evilsoulm.keep_nice.ui.view.activity.FlexBoxLayoutActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Navigator {
    @Inject
    public Navigator() {
    }

    public void navigatorToWebView(@NonNull Context context, Feed feed) {
//        Intent intentToLaunch = WebViewActivity.getCallingIntent(context, feed);
//        context.startActivity(intentToLaunch);
        Intent intent = new Intent(context, BindViewActivity.class);
        context.startActivity(intent);
    }


    public void navigatorToFlexBoxLayoutActivity(Context context) {
        Intent intentToFlexBox = new Intent(context, FlexBoxLayoutActivity.class);
        context.startActivity(intentToFlexBox);
    }
}