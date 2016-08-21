package com.evilsoulm.keep_nice.ui.view.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.evilsoulm.keep_nice.R;
import com.evilsoulm.keep_nice.databinding.ActivityBindViewBinding;
import com.evilsoulm.keep_nice.model.dao.entity.Feed;

public class BindViewActivity extends AppCompatActivity {
    private Feed feed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long startTime = System.currentTimeMillis();
        setContentView(R.layout.activity_bind_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        TextView tv4 = (TextView) findViewById(R.id.tv4);
        TextView tv5 = (TextView) findViewById(R.id.tv5);
        TextView tv6 = (TextView) findViewById(R.id.tv6);
        TextView tv7 = (TextView) findViewById(R.id.tv7);
        TextView tv8 = (TextView) findViewById(R.id.tv8);
        TextView tv9 = (TextView) findViewById(R.id.tv9);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Log.d("EvilsoulM", "costTime:" + (System.currentTimeMillis() - startTime));

        long bindTime = System.currentTimeMillis();
        ActivityBindViewBinding activityBindViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_bind_view);
        Log.d("EvilsoulM", "bindViewTime:" + (System.currentTimeMillis() - bindTime));
        setSupportActionBar(activityBindViewBinding.toolbar);
        activityBindViewBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feed._id.set("new Id");
                feed.createdAt.set("new CreatedAt");
                feed.desc.set("new desc");
                feed.publishedAt.set("new PublishedAt");
                feed.source.set("new source");
                feed.type.set("new type");
                feed.url.set("new url");
                feed.who.set("new who");
            }
        });
        feed = new Feed();
        feed._id.set("id");
        feed.createdAt.set("CreatedAt");
        feed.desc.set("desc");
        feed.publishedAt.set("PublishedAt");
        feed.source.set("source");
        feed.type.set("type");
        feed.url.set("url");
        feed.who.set("who");
        activityBindViewBinding.setFeed(feed);
    }

}
