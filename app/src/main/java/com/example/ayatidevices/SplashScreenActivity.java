package com.example.ayatidevices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.ayatidevices.utils.PreferenceUtils;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;
    private Context context;
    PreferenceUtils pref;
    private boolean keepmeLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        context = SplashScreenActivity.this;
        pref=new PreferenceUtils(context);
        nextActivity();
    }


//    public void nextActivity() {
//        new Handler().postDelayed(() -> {
//            Intent intent = null;
//            if (pref.isLogin() && keepmeLogin) {
//                intent = new Intent(context, HomeActivity.class);
//            } else {
//                intent = new Intent(context, MainActivity.class);
//            }
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//            finish();
//        }, SPLASH_TIME_OUT);
//    }

    public void nextActivity() {
        new Handler().postDelayed(() -> {
            Intent intent = null;
            intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }, SPLASH_TIME_OUT);
    }
}
