package com.pradhanrishi.www.mord;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class ApplicationUtility {

    private static String module = String.valueOf(ApplicationUtility.class);
    ConnectivityManager connectivityManager;
    NetworkInfo info;

    public boolean checkConnection(Context context) {
        boolean flag = false;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            info = connectivityManager.getActiveNetworkInfo();
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                flag = true;
            }
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                flag = true;
            }
            Log.i(module, info.getTypeName());
        } catch (Exception exception) {
            Log.e(module, "Exception at network connection...." + exception);
        }
        return flag;
    }

}