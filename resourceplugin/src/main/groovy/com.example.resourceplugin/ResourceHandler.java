package com.example.resourceplugin;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Author by mazixuan
 * Data:2016-10-21 15:50
 * Project:Keep_Nice
 * Detail:
 */

public abstract class ResourceHandler {
    private static long smallerthan20k = 0;
    private static long between20kand50k = 0;
    private static long morethan50k = 0;
    private static long dian9 = 0;
    private static ArrayList<String> file_list_morethan50k;
    private static ArrayList<String> file_list_between20kand50k;
    private static ArrayList<String> file_list_smallerthan20k;
    private static ArrayList<Point9> file_list_dian9;
    Config mExtension;

    public ResourceHandler(Config mExtension) {
        this.mExtension = mExtension;
        file_list_morethan50k = new ArrayList<>();
        file_list_between20kand50k = new ArrayList<>();
        file_list_smallerthan20k = new ArrayList<>();
        file_list_dian9 = new ArrayList<>();
    }

    public static void getFileSize(File file, int flag) {
        long fileS = file.length();
        DecimalFormat df = new DecimalFormat("#.00");
        float n = Float.parseFloat(df.format((double) fileS / 1024));
        if (flag == 0) {
            dian9 += fileS;
            file_list_dian9.add(new Point9(file.getName(), (int) fileS));
        } else {
            if (n >= 50) {
                morethan50k += fileS;
                file_list_morethan50k.add(file.getName() + "  path:  " + file.getPath());
            } else if (n <= 20) {
                smallerthan20k += fileS;
                file_list_smallerthan20k.add(file.getName());
            } else if (n > 20 && n < 50) {
                between20kand50k += fileS;
                file_list_between20kand50k.add(file.getName() + "  path:  " + file.getPath());
            }
        }
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    public static String formetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "K";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "M";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "G";
        }
        return fileSizeString;
    }

    public abstract boolean isSupport(File file);

    public abstract void handle(File file);

    public void getResult() {
        System.out.println("\nmore than 50k:\n");
        for (int i = 0; i < file_list_morethan50k.size(); i++) {
            System.out.println(file_list_morethan50k.get(i) + "");
        }
        System.out.println("-----------------------------------------------");
        System.out.println("\nbetween 20k and 50k:\n");
        for (int i = 0; i < file_list_between20kand50k.size(); i++) {

            System.out.println(file_list_between20kand50k.get(i) + "");
        }
        System.out.println("-----------------------------------------------");
        System.out.println("\nsmall than 20k:\n");
        for (int i = 0; i < file_list_smallerthan20k.size(); i++) {

            System.out.println(file_list_smallerthan20k.get(i) + "");
        }
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");
        System.out.println("\n .9 picture:\n");
        Collections.sort(file_list_dian9);
        for (int i = 0; i < file_list_dian9.size(); i++) {

            System.out.println(file_list_dian9.get(i).name + "     " + formetFileSize(file_list_dian9.get(i).filesize));
        }
        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

        System.out.println("\ntotal:small20k:   " + formetFileSize(smallerthan20k));
        System.out.println("total:between20kand50k:   " + formetFileSize(between20kand50k));
        System.out.println("total:morethan50k:   " + formetFileSize(morethan50k));
        System.out.println("total:.9 size:   " + formetFileSize(dian9));
    }

    static class Point9 implements Comparable<Point9> {
        public String name = "";
        public int filesize;

        Point9(String name, int filesize) {
            this.name = name;
            this.filesize = filesize;
        }

        @Override
        public int compareTo(Point9 o) {
            if (this.filesize >= o.filesize)
                return -1;
            else {
                return 1;
            }
        }
    }
}
