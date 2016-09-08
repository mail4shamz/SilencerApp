package com.mohammed.shameem.silencerapp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.nfc.Tag;
import android.util.Log;

import com.mohammed.shameem.silencerapp.services.WifiFinderService;
import com.mohammed.shameem.silencerapp.views.MainActivity;

public class StartUpReceiver extends BroadcastReceiver {
    private NetworkInfo info;
    private Intent startIntent;
    private char quotes ='"';
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
            startIntent=new Intent(context, MainActivity.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startIntent);
        } else {
            Log.e("Start Up receiver", "Not working");
        }

        info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        if(info != null && info.isConnected()) {
            // Do your work.
            // e.g. To check the Network Name or other info:
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            String ssid = wifiInfo.getSSID();
            Log.e(getClass().getSimpleName(),"Connected to the Wifi "+ssid+" in Office");
            Log.e(getClass().getSimpleName(),ssid);
            if (ssid.equalsIgnoreCase(quotes+"xminds-dev"+quotes)&&info.isConnected()){
                Log.e(getClass().getSimpleName(),"Inside the if connected statement");
                context.startService(new Intent(context, WifiFinderService.class));
            }
            else {
                Log.e(getClass().getSimpleName(),"Inside the else not working connected statement");
            }


        }


    }
}
