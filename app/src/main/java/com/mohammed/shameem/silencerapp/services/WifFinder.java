package com.mohammed.shameem.silencerapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class WifFinder extends Service {
    public WifFinder() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
