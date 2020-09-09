package com.example.myapplication;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProsedurNPWP extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    FloatingActionButton playIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prosedur_npwp);

        mediaPlayer = new MediaPlayer();

        mediaPlayer = MediaPlayer.create(this,R.raw.prosedur);
        mediaPlayer.start();

        playIcon = findViewById(R.id.playIcon);

        playIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(!mediaPlayer.isPlaying()){
                     mediaPlayer.start();
                     playIcon.setImageResource(R.drawable.ic_pause_white_24dp);
                 }else {
                     mediaPlayer.pause();
                     playIcon.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                }
            }
        });


        Button btndaftar= (Button) findViewById(R.id.btn_daftar);
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.release();
                Intent starts = new Intent(ProsedurNPWP.this,NPWP.class);
                startActivity(starts);
                starts.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });
    }

    public void onBackPressed(){
        mediaPlayer.release();
        ProsedurNPWP.super.onBackPressed();
    }

    public void onUserLeaveHint(){
        mediaPlayer.release();
        ProsedurNPWP.super.onUserLeaveHint();
//        Intent setIntent = new Intent(Intent.ACTION_MAIN);
//        setIntent.addCategory(Intent.CATEGORY_HOME);
//        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(setIntent);

    }
}
