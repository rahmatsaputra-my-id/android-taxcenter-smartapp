package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class RpsList extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.openinbrowser,menu);
        menuInflater.inflate(R.menu.openinbrowser2,menu);
        menuInflater.inflate(R.menu.openinbrowser3,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.openBrowser:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://taxcenter.gunadarma.ac.id/"));
                browserIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(browserIntent);
                return true;

            case R.id.openBrowser2:
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gunadarma.ac.id/"));
                browserIntent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(browserIntent2);
                return true;

            case R.id.openBrowser3:
                Intent browserIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://djponline.pajak.go.id/account/login#"));
                browserIntent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(browserIntent3);
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btn1 = (Button) findViewById(R.id.Buddha);
        Button btn2 = (Button) findViewById(R.id.Hindu);
        Button btn3 = (Button) findViewById(R.id.katholik);
        Button btn4 = (Button) findViewById(R.id.kristen);
        Button btn5 = (Button) findViewById(R.id.indonesia);
        Button btn6 = (Button) findViewById(R.id.islam);
        Button btn7 = (Button) findViewById(R.id.kewarganegaraan);
        Button btn8 = (Button) findViewById(R.id.pancasila);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts = new Intent(RpsList.this, Budha.class);
                startActivity(starts);
                starts.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start2 = new Intent(RpsList.this, Hindu.class);
                startActivity(start2);
                start2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts3 = new Intent(RpsList.this,Katholik.class);
                startActivity(starts3);
                starts3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts4 = new Intent(RpsList.this, Kristen.class);
                startActivity(starts4);
                starts4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts5 = new Intent(RpsList.this, Indonesia.class);
                startActivity(starts5);
                starts5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts6 = new Intent(RpsList.this, Islam.class);
                startActivity(starts6);
                starts6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts7 = new Intent(RpsList.this, Kewarganegaraan.class);
                startActivity(starts7);
                starts7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts8 = new Intent(RpsList.this, Pancasila.class);
                startActivity(starts8);
                starts8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

    }
}
