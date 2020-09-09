package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView tv1 = (TextView) findViewById(R.id.bee);
        TextView tv2 = (TextView) findViewById(R.id.smart);
        TextView tv3 = (TextView) findViewById(R.id.ver);
        ImageView img1 =(ImageView) findViewById(R.id.SmartLogo);

//        Animation animImg = AnimationUtils.loadAnimation(this,R.anim.splash_anim);
//        Animation animTv1 = AnimationUtils.loadAnimation(this,R.anim.splash_anim2);
//        Animation animTv2 = AnimationUtils.loadAnimation(this,R.anim.splash_anim3);
        Animation animTv3 = AnimationUtils.loadAnimation(this,R.anim.splash_anim);

//        img1.startAnimation(animImg);
//        tv1.startAnimation(animTv1);
//        tv2.startAnimation(animTv2);
        tv3.startAnimation(animTv3);

        final Intent i = new Intent(this,MainActivity.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(1400);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                finally {
                    startActivity(i);
                    finish();
                }
            }
        };

        timer.start();
    }
}
