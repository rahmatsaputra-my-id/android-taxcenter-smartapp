package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class Pancasila extends AppCompatActivity {

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

    PDFView book2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pancasila);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        book2 = (PDFView) findViewById(R.id.pdfPancasila);

        book2.fromAsset("Pancasila.pdf").load();
    }
}
