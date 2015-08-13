package study.zhangjun.mystudy.utils;

import android.content.ClipData;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 获取一些App系统的参数
 * Created by cpacm on 2015/6/27.
 */
public class SystemParamsUtil {

    public static final String WXId = "jifenshenghuo";
    public static final String AppUri = "https://t.alipayobjects.com/images/partner/T1rIlgXc0lXXbMsGbX.html";
    public static final String ContactMailTo = "BD@caitu99.com";
    public static final String QuestionMailTo = "Requirement@caitu99.com";
    public static final String Market = "market://details?id=" + "com.caitu99.ifen";

    /**
     * 获取版本号
     * @param context
     * @return
     */
    public static String getAppVersionName(Context context){
        PackageManager manager = context.getPackageManager();
        String appVersionName = "";
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            appVersionName = info.versionName; // 版本名，versionCode同理
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersionName;
    }

    /**
     * 检查网络是否连接
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context){
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 检查WIFI网络是否连接
     * @param context
     * @return
     */
    public static boolean isWIFIConnected(Context context){
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mWiFiNetworkInfo != null) {
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 检查手机网络是否可用
     * @param context
     * @return
     */
    public static boolean isMobileConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mMobileNetworkInfo = mConnectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (mMobileNetworkInfo != null) {
                return mMobileNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    /**
     * 设置文字到粘贴板
     * @param context
     */
    public static void setPrimaryClip(Context context){
        android.content.ClipboardManager c = (android.content.ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
        c.setPrimaryClip(ClipData.newPlainText("wechat", WXId));
/*        if (android.os.Build.VERSION.SDK_INT > 11) {
            android.content.ClipboardManager c = (android.content.ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
            c.setPrimaryClip(ClipData.newPlainText("wechat", "jifenshenghuo"));
        } else {
            android.text.ClipboardManager c = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            c.setText("jifenshenghuo");
        }*/
    }


}
