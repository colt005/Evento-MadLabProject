package com.mahe.evento;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Toast.makeText(SplashActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_splash);

        iv = (ImageView) findViewById(R.id.splashapplogo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);

        iv.startAnimation(animation);
        final Intent i = new Intent(this, SignupActivity.class);
        Thread timer = new Thread() {

            public void run() {
                try {
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }

            }
        };
        timer.start();
    }


}




