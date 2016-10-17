package com.mohammed.shameem.silencerapp.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.Log;

public class WifiFinderService extends Service {
    private AudioManager audiotape;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("OnCreate Called", "OSC");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("OnStart Called", "OSC Called");
        audiotape = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i <= 2; i++) {
                        audiotape.setRingerMode(AudioManager.RINGER_MODE_SILENT);
                        Thread.sleep(0);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
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
