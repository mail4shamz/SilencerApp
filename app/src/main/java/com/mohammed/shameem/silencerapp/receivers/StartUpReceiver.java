package com.mohammed.shameem.silencerapp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mohammed.shameem.silencerapp.R;
import com.mohammed.shameem.silencerapp.services.WifiFinderService;
import com.mohammed.shameem.silencerapp.views.MainActivity;

public class StartUpReceiver extends BroadcastReceiver {
    private NetworkInfo info;
    private Intent startIntent;
    private char quotes = '"';
    private String ssid;
    private WifiInfo wifiInfo;
    private WifiManager wifiManager;

    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
            startIntent = new Intent(context, MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startIntent);
        }

        info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        if (info != null && info.isConnected()) {
            // Do your work.
            // e.g. To check the Network Name or other info:
            wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            wifiInfo = wifiManager.getConnectionInfo();
            ssid = wifiInfo.getSSID();

            if (ssid.equalsIgnoreCase(quotes + context.getString(R.string.office_ssid) + quotes) && info.isConnected()) {
                context.startService(new Intent(context, WifiFinderService.class));
            }

        }


    }
}
