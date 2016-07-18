package com.evilsoulm.keep_nice.common.parser;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * Author by mazixuan
 * Data:2016-07-17 22:40
 * Project:Keep_Nice
 * Detail:
 */

public class ViewBinderParser {
    /**
     * 初始化解析
     *
     * @param object
     */
    public static void inject(Object object) {
        // 创建解析对象并开始执行解析方法
        ViewBinderParser parser = new ViewBinderParser();
        try {
            parser.parser(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 开始执行解析方法
     *
     * @param object
     * @throws Exception
     */
    public void parser(final Object object) throws Exception {
        View view = null;
        // 获取目标对象字节码
        final Class<?> clazz = object.getClass();
        // 获取目标对象定义的成员变量
        Field[] fields = clazz.getDeclaredFields();
        // 循环遍历成员变量
        for (Field field : fields) {
            if (field.isAnnotationPresent(ViewBinder.class)) {
                ViewBinder inject = field.getAnnotation(ViewBinder.class);
                int id = inject.id();
                if (id < 0) {
                    throw new Exception("id must not be null!!!");
                }
                if (id > 0) {
                    field.setAccessible(true);
                    if (object instanceof View) {
                        view = ((View) object).findViewById(id);
                    } else if (object instanceof Activity) {
                        view = ((Activity) object).findViewById(id);
                    }
                    field.set(object, view);// 给我们要找的字段设置id
                }
            }
        }
    }
}
