package com.esprit.koorafan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.CheckBox;

public class SplashActivity extends Activity {
    Handler handler;
    private SharedPreferences mSharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        mSharedPref = getSharedPreferences("com.esprit.koora.file1", MODE_PRIVATE);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(SplashActivity.this,MainActivity.class);

                if (mSharedPref.getBoolean("REMEMBERED",false)){
                    intent=new Intent(SplashActivity.this,HomeActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
