package com.evilsoulm.keep_nice.ui.view.component;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.evilsoulm.keep_nice.common.ImageLoader;
import com.evilsoulm.keep_nice.common.KeepApplication;

import javax.inject.Inject;

/**
 * Author by EvilsoulM
 * Data:2016-05-05 22:06
 * Project:Keep_Nice
 * Detail:
 */
public class RemoteImageView extends ImageView {
    @Inject
    ImageLoader imageLoader;

    public RemoteImageView(Context context) {
        this(context, null);
    }

    public RemoteImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RemoteImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        KeepApplication.getApplication().getApplicationComponent().inject(this);
    }

    public void setUri(Uri uri) {
        imageLoader.load(this, uri);
    }
}
