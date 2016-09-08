package com.mohammed.shameem.silencerapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class WifiFinderService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("OnCreate Called","OSC");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("OnStart Called","OSC Called");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }
}
