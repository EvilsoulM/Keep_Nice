package com.evilsoulm.keep_nice.common;

import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.IOException;


public class ImageLoader {

    private RequestManager glideRequestManager;

    public ImageLoader(RequestManager requestManager) {
        this.glideRequestManager = requestManager;
    }

    /**
     * @param imageUrl
     * @throws IOException
     */
    public void load(String imageUrl) throws IOException {
        glideRequestManager.load(imageUrl).preload();
    }

    /**
     * @param imageView
     * @param ImageResId
     */
    public void load(ImageView imageView, int ImageResId) {
        glideRequestManager.load(ImageResId).into(imageView);
    }

    /**
     * @param imageView
     * @param file
     */
    public void load(ImageView imageView, File file) {
        glideRequestManager.load(file).skipMemoryCache(true).into(imageView);
    }

    /**
     * @param imageView
     * @param imageUrl
     */
    public void load(ImageView imageView, String imageUrl) {
        glideRequestManager.load(imageUrl).into(imageView);
    }

    /**
     * 此方法主要是为图片加载提供了一个加载完成的回调接口
     *
     * @param imageView
     * @param imageUrl
     */
    public void load(ImageView imageView, String imageUrl, RequestListener requestListener) {
        glideRequestManager.load(imageUrl).skipMemoryCache(true).listener(requestListener).into(imageView);
    }

    /**
     * @param imageView
     * @param imageResId
     * @param placeResId
     */
    public void load(ImageView imageView, int imageResId, int placeResId) {
        glideRequestManager.load(imageResId).placeholder(placeResId).into(imageView);
    }

    /**
     * @param imageView
     * @param imageUrl
     * @param placeResId
     */
    public void load(ImageView imageView, String imageUrl, int placeResId) {
        glideRequestManager.load(imageUrl).placeholder(placeResId).into(imageView);
    }

    /**
     * @param imageView
     * @param imageUrl
     * @param placeResId
     * @param errorResId
     */
    public void load(ImageView imageView, String imageUrl, int placeResId, int errorResId) {
        glideRequestManager.load(imageUrl).placeholder(placeResId).error(errorResId).into(imageView);
    }


    /**
     * 此方法主要是通过fit()方法对图片进行处理方便其更好的填充到ImageView中
     *
     * @param imageView
     * @param imageUrl
     * @param placeResId
     */
    public void loadFit(ImageView imageView, String imageUrl, int placeResId) {
        glideRequestManager.load(imageUrl).placeholder(placeResId).into(imageView);
    }


    /**
     * 该方法可以通过callback的onSuccess方法在缓存成功之后进行下一步操作
     *
     * @param imageUrl
     * @param callback
     */
    public void loadFetch(String imageUrl, RequestListener callback) {
        glideRequestManager.load(imageUrl).listener(callback);
    }

    /**
     * @param imageView
     * @param imageUrl
     * @param errorResId
     */
    public void loadError(ImageView imageView, String imageUrl, int errorResId) {
        glideRequestManager.load(imageUrl).error(errorResId).into(imageView);
    }

    /**
     * 此方法主要是通过Transformation对下载后的图片进行预处理
     *
     * @param imageView
     * @param placeResId
     * @param transformation
     */
    public void loadTransformation(ImageView imageView, int placeResId, BitmapTransformation transformation) {
        glideRequestManager.load(placeResId).transform(transformation).into(imageView);
    }

    /**
     * @param imageView
     * @param imageUrl
     * @param transformation
     */
    public void loadTransformation(ImageView imageView, String imageUrl, BitmapTransformation transformation) {
        glideRequestManager.load(imageUrl).transform(transformation).into(imageView);
    }

    /***
     * @param imageView
     * @param imageUrl
     * @param placeResId
     * @param transformation
     */
    public void loadTransformation(ImageView imageView, String imageUrl, int placeResId, BitmapTransformation transformation) {
        glideRequestManager.load(imageUrl).placeholder(placeResId).transform(transformation).into(imageView);
    }

    /**
     * @param target
     * @param imageUrl
     */
    public void loadTarget(Target target, String imageUrl) {
        glideRequestManager.load(imageUrl).into(target);
    }

    /**
     * @param target
     * @param imageUrl
     * @param placeResId
     */
    public void loadTarget(Target target, String imageUrl, int placeResId) {
        glideRequestManager.load(imageUrl).placeholder(placeResId).into(target);
    }

    /**
     * @param imageView
     * @param imageUrl
     */
    public void loadCallback(ImageView imageView, String imageUrl, RequestListener requestListener) {
        glideRequestManager.load(imageUrl).listener(requestListener).into(imageView);
    }

    /**
     * @param imageView
     * @param imageUrl
     * @param placeResId
     */
    public void loadCallback(ImageView imageView, String imageUrl, int placeResId, RequestListener requestListener) {
        glideRequestManager.load(imageUrl).placeholder(placeResId).listener(requestListener).into(imageView);
    }

    /**
     * load 本地图片如相册，用户的联系人头像，本地file文件
     */
    public void loadLocalFile(ImageView imageView, Uri uri) {
        glideRequestManager.load(uri).into(imageView);
    }

    public void load(ImageView imageView, Uri uri) {
        glideRequestManager.load(uri).into(imageView);
    }


}

