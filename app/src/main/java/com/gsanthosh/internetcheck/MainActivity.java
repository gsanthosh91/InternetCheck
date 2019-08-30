package com.gsanthosh.internetcheck;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends BaseActivity implements ConnectionReceiver.ConnectionReceiverListener {

    String TAG = "CHECKKING";
    ConnectionReceiver internetReceiver = new ConnectionReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerInternetReceiver();


    }

    @Override
    protected void onResume() {
        super.onResume();

        showInternetSnackbar(findViewById(R.id.item_view), ConnectionReceiver.isConnected());
    }


    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showInternetSnackbar(findViewById(R.id.item_view), isConnected);

    }

    private void registerInternetReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(internetReceiver, intentFilter);

        ConnectionReceiver.setConnectionListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(internetReceiver);
    }

}
