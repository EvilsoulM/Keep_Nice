package com.evilsoulm.common.Utils;

import android.util.Log;

/**
 * Author by mazixuan
 * Data:2015-12-11 10:22
 * Project:Keep_Nice
 * Detail:
 */
public class ImageLoader {
    private static final String TAG = "EvilsoulM";

    public static void loadImage(String url) {
        Log.d(TAG, "loadImage() called with: " + "url = [" + url + "]");
    }

    public static void loadImage(String url, int placeholder) {
        Log.d(TAG, "loadImage() called with: " + "url = [" + url + "], placeholder = [" + placeholder + "]");
    }

    public static void loadImage(String url, int placeholder, int errorHolder) {
        Log.d(TAG, "loadImage() called with: " + "url = [" + url + "], placeholder = [" + placeholder + "], errorHolder = [" + errorHolder + "]");
    }

    public static void loadImage(String url, int errorHolder, boolean isFade) {
        Log.d(TAG, "loadImage() called with: " + "url = [" + url + "], errorHolder = [" + errorHolder + "], isFade = [" + isFade + "]");

    }

    public static void loadImage(String url, boolean isFade) {
        Log.d(TAG, "loadImage() called with: " + "url = [" + url + "], isFade = [" + isFade + "]");
    }

    public static void loadImage(String url, boolean isFade, int placeHolder) {
        Log.d(TAG, "loadImage() called with: " + "url = [" + url + "], isFade = [" + isFade + "], placeHolder = [" + placeHolder + "]");
    }
}
