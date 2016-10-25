package com.example.resourceplugin;

import java.io.File;

/**
 * Author by mazixuan
 * Data:2016-10-21 15:51
 * Project:Keep_Nice
 * Detail:
 */

public class DrawableHandler extends ResourceHandler {

    public DrawableHandler(Config mExtension) {
        super(mExtension);
    }

    @Override
    public boolean isSupport(File file) {
        return mExtension.drawable && file.isDirectory() && file.getAbsolutePath().contains("drawable");
    }

    @Override
    public void handle(File file) {
        System.out.println("file:" + file.toString());
        if (file.isDirectory() && file.length() > 0) {
            for (File itemFile : file.listFiles()) {
                if (getFileExtension(itemFile).equals("png")) {
                    String filename;
                    filename = itemFile.getName();
                    String name = filename.substring(0, filename.lastIndexOf("."));
                    if (name.lastIndexOf(".") == -1) {
                        getFileSize(itemFile, 1);
                    } else {
                        getFileSize(itemFile, 0);
                    }
                }
            }
        }
    }
}
