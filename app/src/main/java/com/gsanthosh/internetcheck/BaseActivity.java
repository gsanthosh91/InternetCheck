package com.gsanthosh.internetcheck;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void showInternetSnackbar(View view, boolean isConnected) {
        Log.d("MY_NETWORK", isConnected ? "CONNECTED" : "DISCONNECTED");
        if (!isConnected) {
            Snackbar mySnack = Snackbar.make(view, "No network connections!", Snackbar.LENGTH_LONG);
            mySnack.setAction("Settings", new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    BaseActivity.this.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
                }
            }).show();
        }
    }

}
