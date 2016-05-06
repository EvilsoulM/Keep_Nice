package com.evilsoulm.keep_nice.ui.view.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.evilsoulm.keep_nice.R;
import com.evilsoulm.keep_nice.common.base.BaseActivity;
import com.evilsoulm.keep_nice.ui.FeedFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import butterknife.Bind;

public class MainActivity extends BaseActivity {
    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Bind(R.id.viewpagertab)
    SmartTabLayout viewpagerTab;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupTabView();
    }

    protected void setupTabView() {
        final LayoutInflater inflater = LayoutInflater.from(this);
        final int[] tabIcons = {R.mipmap.actor_evaluation, R.mipmap.actor_life, R.mipmap.actor_society, R.mipmap.actor_trivia};
        FragmentPagerItems pages = FragmentPagerItems.with(this)
                .add(R.string.recommended, FeedFragment.class)
                .add(R.string.topics, FeedFragment.class)
                .add(R.string.wiki, FeedFragment.class)
                .add(R.string.me, FeedFragment.class)
                .create();
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(),
                pages);

        viewPager.setOffscreenPageLimit(pages.size());
        viewPager.setAdapter(adapter);
        viewpagerTab.setCustomTabView((container, position, pagerAdapter) -> {
            View view = inflater.inflate(R.layout.custom_tab_icon, container, false);
            ImageView iconView = (ImageView) view.findViewById(R.id.iv_icon);
            iconView.setBackgroundResource(tabIcons[position % tabIcons.length]);
            return view;
        });
        viewpagerTab.setViewPager(viewPager);
    }
}
