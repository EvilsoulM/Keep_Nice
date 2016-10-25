package com.example.resourceplugin;

import java.io.File;

/**
 * Author by mazixuan
 * Data:2016-10-21 15:51
 * Project:Keep_Nice
 * Detail:
 */

public class MipmapHandler extends ResourceHandler {
    public MipmapHandler(Config mExtension) {
        super(mExtension);
    }

    @Override
    public boolean isSupport(File file) {
        return mExtension.mipmap && file.isDirectory() && file.getAbsolutePath().contains("mipmap");
    }

    @Override
    public void handle(File file) {
        System.out.println("file:" + file.toString());
    }
}
