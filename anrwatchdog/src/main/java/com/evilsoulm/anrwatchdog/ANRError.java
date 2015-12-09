package com.evilsoulm.anrwatchdog;

import android.os.Looper;

import java.util.HashMap;
import java.util.Map;

/**
 * Author by mazixuan
 * Data:2015-10-20 18:37
 */
public class ANRError extends Error {
    private static final long serialVersionUID = 1L;
    private final Map<Thread, StackTraceElement[]> stackTraces;

    public ANRError($._Thread st, Map<Thread, StackTraceElement[]> stackTraces) {
        super("Application Not Responding", st);
        this.stackTraces = stackTraces;
    }

    public static ANRError NewMainOnly() {
        final Thread mainThread = Looper.getMainLooper().getThread();
        final StackTraceElement[] mainStackTrace = mainThread.getStackTrace();

        final HashMap<Thread, StackTraceElement[]> stackTraces = new HashMap<>(1);
        stackTraces.put(mainThread, mainStackTrace);

        return new ANRError(new $(mainThread.getName(), mainStackTrace).new _Thread(null), stackTraces);
    }

    public Map<Thread, StackTraceElement[]> getStackTraces() {
        return stackTraces;
    }

    @Override
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[]{});
        return this;
    }

    private static class $ {
        private final String name;
        private final StackTraceElement[] stackTrace;

        private $(String name, StackTraceElement[] stackTrace) {
            this.name = name;
            this.stackTrace = stackTrace;
        }

        private class _Thread extends Throwable {
            private _Thread(_Thread other) {
                super(name, other);
            }

            @Override
            public Throwable fillInStackTrace() {
                setStackTrace(stackTrace);
                return this;
            }
        }
    }
}