package com.wei.forcedoffline;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    private IntentFilter intentFilter;
    private MyReciver myReciver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        myReciver = new MyReciver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.wei.forceoffline");
        localBroadcastManager.registerReceiver(myReciver, intentFilter);

        ((TextView) findViewById(R.id.text)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.wei.forceoffline");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(myReciver);
    }
}
