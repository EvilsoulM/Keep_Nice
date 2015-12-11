package com.evilsoulm.keep_nice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.evilsoulm.common.Utils.ImageLoader;
import com.evilsoulm.common.Utils.LogUtils;
import com.evilsoulm.common.annotation.MethodTime;

public class MainActivity extends AppCompatActivity {
    private static final String URL = "api.maoyan.com";
    private static final int ERROR_ID = 0x11;
    private static final int PLACE_HOLDER_ID = 0x12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        init("name->EvilsoulM");

        ImageLoader.loadImage("");
        ImageLoader.loadImage("", ERROR_ID);
        ImageLoader.loadImage("", ERROR_ID, PLACE_HOLDER_ID);
        ImageLoader.loadImage("", ERROR_ID, true);
        ImageLoader.loadImage(URL, false);
        ImageLoader.loadImage(URL, false, PLACE_HOLDER_ID);
    }

    @MethodTime
    private void init(String args) {
        LogUtils.log("init() called with: " + args);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
