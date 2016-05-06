package com.evilsoulm.common.Utils;

import android.app.ActivityManager;
import android.content.Context;

/**
 * Author by EvilsoulM
 * Data:2016-05-04 11:27
 * Project:Keep_Nice
 * Detail:
 */
public class SysUtils {
    public static String getCurrentProcessName(Context context) {
        String currentProcName = "";
        int pid = android.os.Process.myPid();
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (manager == null) {
            return "";
        }

        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                currentProcName = processInfo.processName;
            }
        }

        return currentProcName;
    }


}
