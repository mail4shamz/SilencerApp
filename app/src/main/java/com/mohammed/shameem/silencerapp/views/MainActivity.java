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
        PackageManager p = getPackageManager();
        ComponentName componentName = new ComponentName(this, com.mohammed.shameem.silencerapp.views.MainActivity.class);
        p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
        setContentView(R.layout.activity_main);
        p = getPackageManager();
        componentName = new ComponentName(this, com.mohammed.shameem.silencerapp.views.MainActivity.class); // activity which is first time open in manifiest file which is declare as <category android:name="android.intent.category.LAUNCHER" />
        p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        finish();
        Log.e("MainActivity", "OnCreate");
        MainActivity.this.startService(new Intent(this, WifiFinderService.class));


    }
}
