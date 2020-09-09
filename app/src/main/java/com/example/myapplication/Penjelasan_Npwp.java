package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class Penjelasan_Npwp extends AppCompatActivity {

    HorizontalInfiniteCycleViewPager viewPager;
    List<Item_card> itemCardList  = new ArrayList<>();

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.openinbrowser, menu);
        menuInflater.inflate(R.menu.openinbrowser2, menu);
        menuInflater.inflate(R.menu.openinbrowser3, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
        setContentView(R.layout.activity_penjelasan__npwp);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initData();
        viewPager = (HorizontalInfiniteCycleViewPager) findViewById(R.id.view_pager);
        ItemCardAdapter adapter = new ItemCardAdapter(this,itemCardList);
        viewPager.setAdapter(adapter);
    }

    public void initData(){
        itemCardList.add(new Item_card("Langkah 1",getString(R.string.penjelasan1),R.drawable.step1));
        itemCardList.add(new Item_card("Langkah 2",getString(R.string.penjelasan2),R.drawable.step2));
        itemCardList.add(new Item_card("Langkah 3",getString(R.string.penjelasan3),R.drawable.step3));
        itemCardList.add(new Item_card("Langkah 4",getString(R.string.penjelasan4),R.drawable.step4));
        itemCardList.add(new Item_card("Langkah 5",getString(R.string.penjelasan6),R.drawable.step5));
//        itemCardList.add(new Item_card("Fungsi 3 Digit Kelima",getString(R.string.penjelasan5),R.drawable.logo_brevet));
    }
}
