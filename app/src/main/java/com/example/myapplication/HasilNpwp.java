package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.text.DateFormat;
import java.util.Calendar;

public class HasilNpwp extends AppCompatActivity {
    Dialog epicDialog;
    TextView nd ,nb ,jln, blk, nik, nmr, rt, rw, klrhn, kcmtn, kt, prvns, rd1, rd2, rd3, rd4, tv_stat, tv_kdWilay;
    String stnd,stnb,stjalan,stblok,stnik, stnomor, strt, strw, stkelurahan, stkecamatan, stkota, stprovinsi, strnd1, strnd2, strnd3,strnd4, ststatus, stKode_wlyh;

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

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1,floatingActionButton2,floatingActionButton3,floatingActionButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_npwp);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());

        materialDesignFAM = (FloatingActionMenu)findViewById(R.id.social_floating_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.floating_facebook);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.floating_youtube);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                Banner_NPWP0();
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                Intent youtubeIntent = new Intent(HasilNpwp.this,MainActivity.class);
                youtubeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(youtubeIntent);
                finish();

            }
        });

        TextView textViewDate = findViewById(R.id.current_date);
        textViewDate.setText(currentDate);

        nd= findViewById(R.id.namadepan_npwp);
        stnd= getIntent().getExtras().getString("Value");
        nd.setText(stnd);

        nb= findViewById(R.id.namabelakang_npwp);
        stnb= getIntent().getExtras().getString("Value1");
        nb.setText(stnb);

        jln= findViewById(R.id.jalan);
        stjalan= getIntent().getExtras().getString("Value2");
        jln.setText(stjalan);

        blk= findViewById(R.id.blok);
        stblok= getIntent().getExtras().getString("Value3");
        blk.setText(stblok);

        nik= findViewById(R.id.nik_npwp);
        stnik= getIntent().getExtras().getString("Value4");
        nik.setText(stnik);

        nmr= findViewById(R.id.nomor);
        stnomor= getIntent().getExtras().getString("Value5");
        nmr.setText(stnomor);

        rt= findViewById(R.id.tv_rt);
        strt= getIntent().getExtras().getString("Value6");
        rt.setText(strt);

        rw= findViewById(R.id.tv_rw);
        strw= getIntent().getExtras().getString("Value7");
        rw.setText(strw);

        klrhn = findViewById(R.id.kelurahan);
        stkelurahan= getIntent().getExtras().getString("Value8");
        klrhn.setText(stkelurahan);

        kcmtn = findViewById(R.id.kecamatan);
        stkecamatan= getIntent().getExtras().getString("Value9");
        kcmtn.setText(stkecamatan);

        kt = findViewById(R.id.kota);
        stkota= getIntent().getExtras().getString("Value10");
        kt.setText(stkota);

        prvns = findViewById(R.id.provinsi);
        stprovinsi= getIntent().getExtras().getString("Value11");
        prvns.setText(stprovinsi);

        rd1 = findViewById(R.id.nomor_random1);
        strnd1= getIntent().getExtras().getString("Value12");
        rd1.setText(strnd1);

        rd2 = findViewById(R.id.nomor_random2);
        strnd2= getIntent().getExtras().getString("Value13");
        rd2.setText(strnd2);

        rd3 = findViewById(R.id.nomor_random3);
        strnd3= getIntent().getExtras().getString("Value14");
        rd3.setText(strnd3);

        rd4 = findViewById(R.id.nomor_random4);
        strnd4= getIntent().getExtras().getString("Value15");
        rd4.setText(strnd4);

        tv_stat = findViewById(R.id.tv_status);
        ststatus = getIntent().getExtras().getString("Value16");
        tv_stat.setText(ststatus);

        tv_kdWilay= findViewById(R.id.tv_kdWilayah);
        stKode_wlyh = getIntent().getExtras().getString("Value17");
        tv_kdWilay.setText(stKode_wlyh);

        epicDialog = new Dialog(this);
        Banner_NPWP0();
    }

    public void Banner_NPWP0(){
        epicDialog.setContentView(R.layout.popup_npwp0);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_small);
        crd.startAnimation(animation);


        Button skip = (Button) epicDialog.findViewById(R.id.btn_skip);
        Button next = (Button) epicDialog.findViewById(R.id.btn_next);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP1();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void Banner_NPWP1(){
        epicDialog.setContentView(R.layout.popup_npwp1);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_small);
        crd.startAnimation(animation);


        Button skip = (Button) epicDialog.findViewById(R.id.btn_skip);
        Button next = (Button) epicDialog.findViewById(R.id.btn_next);
        Button prev = (Button) epicDialog.findViewById(R.id.btn_prev);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP0();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP2();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void Banner_NPWP2(){
        epicDialog.setContentView(R.layout.popup_npwp2);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_small);
        crd.startAnimation(animation);


        Button skip = (Button) epicDialog.findViewById(R.id.btn_skip);
        Button next = (Button) epicDialog.findViewById(R.id.btn_next);
        Button prev = (Button) epicDialog.findViewById(R.id.btn_prev);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP1();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP3();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void Banner_NPWP3(){
        epicDialog.setContentView(R.layout.popup_npwp3);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_small);
        crd.startAnimation(animation);


        Button skip = (Button) epicDialog.findViewById(R.id.btn_skip);
        Button next = (Button) epicDialog.findViewById(R.id.btn_next);
        Button prev = (Button) epicDialog.findViewById(R.id.btn_prev);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP2();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP4();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void Banner_NPWP4(){
        epicDialog.setContentView(R.layout.popup_npwp4);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_small);
        crd.startAnimation(animation);


        Button skip = (Button) epicDialog.findViewById(R.id.btn_skip);
        Button next = (Button) epicDialog.findViewById(R.id.btn_next);
        Button prev = (Button) epicDialog.findViewById(R.id.btn_prev);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP3();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP5();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void Banner_NPWP5(){
        epicDialog.setContentView(R.layout.popup_npwp5);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_small);
        crd.startAnimation(animation);


        Button skip = (Button) epicDialog.findViewById(R.id.btn_skip);
        Button next = (Button) epicDialog.findViewById(R.id.btn_next);
        Button prev = (Button) epicDialog.findViewById(R.id.btn_prev);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP4();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP6();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void Banner_NPWP6(){
        epicDialog.setContentView(R.layout.popup_npwp6);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_small);
        crd.startAnimation(animation);


        Button skip = (Button) epicDialog.findViewById(R.id.btn_skip);
        Button prev = (Button) epicDialog.findViewById(R.id.btn_prev);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner_NPWP5();
            }
        });


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }
}
