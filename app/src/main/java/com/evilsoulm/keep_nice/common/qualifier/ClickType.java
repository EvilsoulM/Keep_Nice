package com.evilsoulm.keep_nice.common.qualifier;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static com.evilsoulm.keep_nice.common.qualifier.ClickType.CLICK_TYPE_TOPIC_CLICKED;
import static com.evilsoulm.keep_nice.common.qualifier.ClickType.CLICK_TYPE_USER_CLICKED;
import static java.lang.annotation.RetentionPolicy.SOURCE;

@Retention(SOURCE)
@IntDef({
        CLICK_TYPE_USER_CLICKED,
        CLICK_TYPE_TOPIC_CLICKED
})
public @interface ClickType {
    int CLICK_TYPE_USER_CLICKED = 1000;

    int CLICK_TYPE_TOPIC_CLICKED = 1001;
}