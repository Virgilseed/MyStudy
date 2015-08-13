package study.zhangjun.mystudy.utils;

import android.util.Log;

/**
 * Log帮助类
 * 请在发布时去掉注释
 * Created by Cpacm on 2015/5/15.
 */
public class StudyLogger {

    private static String TAG = "IFEN";

    public static boolean DEBUG = Log.isLoggable(TAG, Log.VERBOSE);

    public static void setTag(String tag) {
        d("Changing log tag to %s", tag);
        TAG = tag;
        // Reinitialize the DEBUG "constant"
        DEBUG = Log.isLoggable(TAG, Log.VERBOSE);
    }

    public static void d(String format, Object... args) {
        //if(!DEBUG) return;
        String msg = (args == null) ? format : String.format(format, args);
        Log.d(TAG, msg);
    }

    public static void v(String format, Object... args) {
        String msg = (args == null) ? format : String.format(format, args);
        //if (DEBUG)
            Log.v(TAG, msg);
    }

    public static void e(String format, Object... args) {
        String msg = (args == null) ? format : String.format(format, args);
        Log.e(TAG, msg);
    }

    public static void wtf(String format, Object... args) {
        String msg = (args == null) ? format : String.format(format, args);
        Log.wtf(TAG, msg);
    }
}
