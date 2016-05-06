package com.evilsoulm.keep_nice.model.dao.restapi;

/**
 * Author by EvilsoulM
 * Data:2016-05-06 13:28
 * Project:Keep_Nice
 * Detail:
 */
public enum FeedType {
    ANDROID("Android"), IOS("iOS"), REST("休息视频"), WELFARE("福利"), EXPAND_RESOURCES("拓展资源"), FRONT_END("前端"), RANDOM("瞎推荐"), APP("App");

    private String type;

    FeedType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
