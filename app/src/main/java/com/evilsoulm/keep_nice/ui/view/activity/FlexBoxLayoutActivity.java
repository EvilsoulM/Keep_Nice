package com.evilsoulm.keep_nice.ui.view.activity;

import android.os.Bundle;

import com.evilsoulm.keep_nice.R;
import com.evilsoulm.keep_nice.common.base.BaseActivity;

/**
 * Author by mazixuan
 * Data:2016-05-16 21:24
 * Project:Keep_Nice
 * Detail:
 */
public class FlexBoxLayoutActivity extends BaseActivity {
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_flex_box;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.flex_box);
//        flexboxLayout.setFlexDirection(FlexboxLayout.FLEX_DIRECTION_COLUMN);
//        View view = flexboxLayout.getChildAt(0);
//        FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) view.getLayoutParams();
//        layoutParams.order = -1;
//        layoutParams.flexGrow = 2;
//        view.setLayoutParams(layoutParams);
    }
}
