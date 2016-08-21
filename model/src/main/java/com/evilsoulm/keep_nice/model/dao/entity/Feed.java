package com.evilsoulm.keep_nice.model.dao.entity;

import android.databinding.ObservableField;

import java.io.Serializable;

/**
 * Author by EvilsoulM
 * Data:2016-05-06 13:50
 * Project:Keep_Nice
 * Detail:
 * 字段	描述	备注
 * url	想要提交的网页地址
 * desc	对干货内容的描述	单独的文字描述
 * who	提交者 ID	干货提交者的网络 ID
 * type	干货类型	可选参数: Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
 * debug	当前提交为测试数据	如果想要测试数据是否合法, 请设置 debug 为 true! 可选参数: true | false
 */
public class Feed implements Serializable {
    public ObservableField<String> _id = new ObservableField<>();
    public ObservableField<String> createdAt = new ObservableField<>();
    public ObservableField<String> desc = new ObservableField<>();
    public ObservableField<String> publishedAt = new ObservableField<>();
    public ObservableField<String> source = new ObservableField<>();
    public ObservableField<String> type = new ObservableField<>();
    public ObservableField<String> url = new ObservableField<>();
    public ObservableField<String> who = new ObservableField<>();
    public boolean used;

}
