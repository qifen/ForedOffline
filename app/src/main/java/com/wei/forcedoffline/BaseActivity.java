package com.wei.forcedoffline;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by weiyilin on 16/11/14.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
