package com.evilsoulm.anrwatchdog;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * Author by mazixuan
 * Data:2015-10-20 18:36
 * Detail: ANR监测器 增加检测debug~不检测anr thanks->pengliang
 * 如果是release版本要使用最好设置时间长一点15s及以上
 */
public class ANRWatchDog extends Thread {
    private static final String TAG = "ANR_Monitor";

    private static final int UNIT = 1000;
    private static final int DEFAULT_ANR_TIMEOUT = 5 * UNIT;
    private static final ANRListener DEFAULT_ANR_LISTENER = new ANRListener() {
        @Override
        public void onAppNotResponding(ANRError error) {
            throw error;
        }
    };
    private static final InterruptionListener DEFAULT_INTERRUPTION_LISTENER = new InterruptionListener() {
        @Override
        public void onInterrupted(InterruptedException exception) {
            Log.w(TAG, "Interrupted: " + exception.getMessage());
        }
    };
    private final Handler uiHandler = new Handler(Looper.getMainLooper());
    private final int timeoutInterval;
    private ANRListener anrListener = DEFAULT_ANR_LISTENER;
    private InterruptionListener interruptionListener = DEFAULT_INTERRUPTION_LISTENER;
    private volatile int tick = 0;
    private final Runnable ticker = new Runnable() {
        @Override
        public void run() {
            tick = (tick + 1) % 10;//保持在10以内减少内存分配
        }
    };

    public ANRWatchDog() {
        this(DEFAULT_ANR_TIMEOUT);
    }

    public ANRWatchDog(int timeoutInterval) {
        super();
        this.timeoutInterval = timeoutInterval;
    }

    public ANRWatchDog setANRListener(ANRListener listener) {
        if (listener == null) {
            this.anrListener = DEFAULT_ANR_LISTENER;
        } else {
            this.anrListener = listener;
        }
        return this;
    }

    public ANRWatchDog setInterruptionListener(InterruptionListener listener) {
        if (listener == null) {
            this.interruptionListener = DEFAULT_INTERRUPTION_LISTENER;
        } else {
            this.interruptionListener = listener;
        }
        return this;
    }

    @Override
    public void run() {
        setName("|ANR-Monitor|");
        int lastTick;
        while (!isInterrupted()) {
            lastTick = tick;
            this.uiHandler.post(ticker);
            try {
                Thread.sleep(timeoutInterval);
            } catch (InterruptedException e) {
                interruptionListener.onInterrupted(e);
                return;
            }
            if (Debug.isDebuggerConnected()) {
                return;
            }
            if (tick == lastTick) {
                ANRError error = ANRError.NewMainOnly();
                anrListener.onAppNotResponding(error);
                return;
            }
        }
    }

    /**
     * 回调ERROR
     */
    public interface ANRListener {
        void onAppNotResponding(ANRError error);
    }

    /**
     * 监测线程被中断回调，可以操作重启线程
     */
    public interface InterruptionListener {
        void onInterrupted(InterruptedException exception);
    }
}