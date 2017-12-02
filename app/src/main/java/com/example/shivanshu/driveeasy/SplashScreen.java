package com.example.shivanshu.driveeasy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static final long SPLASH_DISPLAY_TIME = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                    startActivity(new Intent(SplashScreen.this,FirstActivity.class));
                    finish();
                    overridePendingTransition(R.anim.slide_in_up, R.anim.slide_down_up);
                }
        }, SPLASH_DISPLAY_TIME);
    }
}
