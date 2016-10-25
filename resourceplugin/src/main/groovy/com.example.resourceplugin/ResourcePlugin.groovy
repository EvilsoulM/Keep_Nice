package com.example.resourceplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

public class ResourcePlugin implements Plugin<Project> {
    static final String PLUGIN_NAME = "resourcePlugin";
//
    Project mProject;
    ResourcePluginExtension mExtension;

    MipmapHandler mMipmapHandler;
    DrawableHandler mDrawableHandler;


    void apply(Project project) {

        System.out.println(PLUGIN_NAME + "  start running ~~");
        this.mProject = project;
        this.mExtension = mProject.extensions.create(PLUGIN_NAME, ResourcePluginExtension);

        Config config = new Config();
        config.drawable = true;
//        config.maxSize =
        config.mipmap = true;

        System.out.println("config:" + config.toString());

        mMipmapHandler = new MipmapHandler(config)
        mDrawableHandler = new DrawableHandler(config)

        System.out.println("==========start==============");
        iterateFiles(mProject.rootDir)
        mDrawableHandler.getResult();
        System.out.println("==========end==============");
    }

    private void iterateFiles(File file) {
        if (file == null || file.getAbsolutePath().contains("build/") || file.getAbsolutePath().contains(".idea/")) {
            return;
        }
        def files = file.listFiles()
        if (files != null && files.length > 0) {
            files.each { File itemFile
                ->
                if (mDrawableHandler.isSupport(itemFile)) {
                    mDrawableHandler.handle(itemFile)
                } else if (mMipmapHandler.isSupport(itemFile)) {
                    mMipmapHandler.handle(itemFile)
                } else {
                    iterateFiles(itemFile);
                }
            }
        }
    }

}
