package com.heritsam.majeliscoding1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.heritsam.majeliscoding1.activity.student.StudentActivity;
import com.heritsam.majeliscoding1.helper.DataConfig;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (DataConfig.isLogin(SplashScreenActivity.this)) {
                    startActivity(new Intent(SplashScreenActivity.this, StudentActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    finish();
                }
            }
        }, 2000);
    }
}
