package com.hr190023.salih_selim_sekerci_final.Util;

import android.content.Context;
import android.net.ConnectivityManager;

public class Helpers {
    public static boolean isNetworkConnected(Context context) { //interne bağlı mı
        ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
