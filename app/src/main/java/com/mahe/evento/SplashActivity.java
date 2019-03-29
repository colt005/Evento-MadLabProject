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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


        Toast.makeText(SplashActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_splash);

        iv = (ImageView) findViewById(R.id.splashapplogo);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.transition);

        iv.startAnimation(animation);
        final Intent i = new Intent(this, SignupActivity.class);
        final Thread timer = new Thread() {

            public void run() {
                try {
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    if(user == null) {
                        //user not signed in
                        startActivity(i);
                        finish();
                    }else if(user !=null){
                        //user signed in
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        finish();
                    }
                }

            }
        };
        timer.start();
    }


}




