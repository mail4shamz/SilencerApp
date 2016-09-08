package com.mohammed.shameem.silencerapp.views;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mohammed.shameem.silencerapp.R;
import com.mohammed.shameem.silencerapp.services.WifiFinderService;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finish();
        Log.e("MainActivity", "OnCreate");
        MainActivity.this.startService(new Intent(this, WifiFinderService.class));


    }
}
