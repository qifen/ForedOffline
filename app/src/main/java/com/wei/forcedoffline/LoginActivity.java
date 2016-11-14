package com.wei.forcedoffline;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by weiyilin on 16/11/14.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener{

    private EditText user;
    private EditText passwd;
    private Button button;

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        pref = PreferenceManager.getDefaultSharedPreferences(this);

        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (pref != null && !"".equals(pref.getString("user", ""))){
            user.setText(pref.getString("user", ""));
            passwd.setText(pref.getString("passwd", ""));
        }
    }

    private void initView() {
        user = (EditText) findViewById(R.id.user);
        passwd = (EditText) findViewById(R.id.passwd);
        button = (Button) findViewById(R.id.login);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String u = user.getText().toString();
        String p = passwd.getText().toString();
        if ("111".equals(u) && "111".equals(p)){
            editor = pref.edit();
            editor.putString("user", u);
            editor.putString("passwd", p);
            editor.commit();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "登录成功!", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "用户名或者密码错误!", Toast.LENGTH_SHORT).show();
        }
    }
}
