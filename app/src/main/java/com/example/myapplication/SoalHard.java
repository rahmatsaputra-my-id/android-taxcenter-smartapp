package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

public class SoalHard extends AppCompatActivity {
    private TextView textViewQuestion;
    private TextView textViewScore;
    private TextView textViewQuestionCount;
    private TextView textViewCountDown;
    private RadioButton rbGroup;
    private Button radio1;
    private Button radio2;
    private Button radio3;
    private Button radio4;


    public static final String EXTRA_SCORE = "extraScore";
    private static final long COUNTDOWN_IN_MILLIS = 8000;

    private ColorStateList textColorDefaultCb;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;


    private int score;
    private boolean answered;

    private long backPressedTime;

    int ike = 0;
    int jd = 10;
    int[] arRandom;

    String sCatatan = "";
    Button radA, radB, radC, radD;
    int ke = 0, jumsoal = 5, jumBenarPG = 0;
    String[] arr_idsoal;
    String[] arr_pertanyaan;
    String[] arr_jawabA;
    String[] arr_jawabB;
    String[] arr_jawabC;
    String[] arr_jawabD;
    String[] arr_jawabBenar;

    String[] arrPertanyaan;
    String[] arrKunci;
    String[] arrHasil;

    TextView txtTanya;

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

    private void pindah(){
        Intent i = new Intent(SoalHard.this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis,1000) {
            @Override
            public void onTick(long MillisUntilFinished) {
                timeLeftInMillis = MillisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                selesaiTimer();
                //pindah();
                //updateCountDownText();
            }
        }.start();
    }

    private void finishQuiz(){
        Intent resultIntent=  new Intent();
        resultIntent.putExtra(EXTRA_SCORE, score);
        setResult(RESULT_OK,resultIntent);
        finish();
    }

/*
    public void onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            finishQuiz();
        } else {
            Toast.makeText(this,"Press back again to finish", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }
*/

    public void onDestroy(){
        super.onDestroy();
        if (countDownTimer != null){
            countDownTimer.cancel();
        }
    }

    private  void updateCountDownText(){
        int hours = (int) ((timeLeftInMillis / 1000)/60/60);
        int minutes = (int) ((timeLeftInMillis / 1000)/60)%60;
        int seconds = (int) (timeLeftInMillis / 1000) %60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d",hours ,minutes, seconds);

        textViewCountDown.setText(timeFormatted);

        if (timeLeftInMillis< 10000){
            textViewCountDown.setTextColor(Color.RED);
        } else {
            textViewCountDown.setTextColor(textColorDefaultCb);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal_hard);
        getSupportActionBar().hide();

        textViewQuestion = findViewById(R.id.question);
/*        textViewScore = findViewById(R.id.score);
        textViewQuestionCount = findViewById(R.id.count);*/
        textViewCountDown = findViewById(R.id.countdown);

        epicDialog = new Dialog(this);

        /*getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo3);
        getSupportActionBar().setDisplayUseLogoEnabled(true);*/

        textColorDefaultCb = textViewCountDown.getTextColors();

        //QuizDbHelper dbHelper = new QuizDbHelper(this);
        //questionList = dbHelper.getAllQuestions();

        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        startCountDown();
        pajakUmum1();
        bacaRandom();
        arrPertanyaan = new String[jd];
        arrKunci = new String[jd];
        arrHasil = new String[jd];

        txtTanya = (TextView) findViewById(R.id.question);
        //txtTanyake = (TextView) findViewById(R.id.txtTanyaKe);

        radA = (Button) findViewById(R.id.radio1);
        radA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekJawaban("A");

                konfirmasiA();

            }
        });

        radB = (Button) findViewById(R.id.radio2);
        radB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekJawaban("B");


                konfirmasiB();
            }
        });
        radC = (Button) findViewById(R.id.radio3);
        radC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekJawaban("C");

                konfirmasiC();

            }
        });
        radD = (Button) findViewById(R.id.radio4);
        radD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekJawaban("D");

                konfirmasiD();

            }
        });
        lihat();
    }

    void cekJawaban(String pil) {

        if (arr_jawabBenar[ike].equals(pil)) {
            jumBenarPG = jumBenarPG + 20;
            sCatatan = sCatatan + "Soal-" + (ke + 1) + " Benar,";
            arrHasil[ke] = pil + " :Benar";

        } else {
            sCatatan = sCatatan + "Soal-" + (ke + 1) + " Salah,";
            arrHasil[ke] = pil + " :Salah";

        }

    }

    void bacaRandom() {
        arRandom = uniqueRandomArray(jd);
        for (int i = 0; i < jd; i++) {
            Log.v("Rnd", i + "." + arRandom[i]);
        }
    }

    public static int[] uniqueRandomArray(int n) {
        int[] A = new int[n];
        for (int i = 0; i < A.length; ) {
            if (i == A.length) {
                break;
            }
            int b = (int) (Math.random() * n) + 1;
            if (f(A, b) == false) {
                A[i++] = b;
            }
        }
        return A;
    }

    public static boolean f(int[] A, int n) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == n) {
                return true;
            }
        }
        return false;
    }

    void lihat() {


        ike = arRandom[ke] - 1;

        Log.v("Random", ke + "=" + ike + "");
        txtTanya.setText((ke + 1) + "." + arr_pertanyaan[ike]);
        radA.setText(arr_jawabA[ike]);
        radB.setText(arr_jawabB[ike]);
        radC.setText(arr_jawabC[ike]);
        radD.setText(arr_jawabD[ike]);


        arrKunci[ke] = arr_jawabD[ike];

        if (arr_jawabBenar[ike].equalsIgnoreCase("A")) {
            arrKunci[ke] = arr_jawabA[ike];
        } else if (arr_jawabBenar[ike].equalsIgnoreCase("B")) {
            arrKunci[ke] = arr_jawabB[ike];
        } else if (arr_jawabBenar[ike].equalsIgnoreCase("C")) {
            arrKunci[ke] = arr_jawabC[ike];
        }
        arrPertanyaan[ke] = arr_pertanyaan[ike];

    }

    public void selesaiTimer() {
        if (jumBenarPG <= 40){
            failed();
        } else if(jumBenarPG >= 51 && jumBenarPG <=60){
            successs1();
        } else if (jumBenarPG >=61 && jumBenarPG <= 80){
            successs2();
        } else if (jumBenarPG == 100 ){
            successs3();
        }
    }

    public void selesai() {
        if (jumBenarPG <= 40){
            failed();
        } else if(jumBenarPG >= 51 && jumBenarPG <=60){
            successs1();
        } else if (jumBenarPG >=61 && jumBenarPG <= 80){
            successs2();
        } else if (jumBenarPG == 100 ){
            successs3();
        }
    }

    Dialog epicDialog;
    Button btnOk;
    ImageView btnClose;
    TextView msg,title,pts;

    public void successs1(){
        epicDialog.setContentView(R.layout.popup_success1);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_nothing);
        crd.startAnimation(animation);

        btnOk = (Button) epicDialog.findViewById(R.id.btn_ok);
        btnClose = (ImageView) epicDialog.findViewById(R.id.btn_close);
        msg = (TextView) epicDialog.findViewById(R.id.message);
        title = (TextView) epicDialog.findViewById(R.id.tittle);
        pts =(TextView) epicDialog.findViewById(R.id.point);

        pts.setText(String.valueOf(jumBenarPG));

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
                Intent i = new Intent(SoalHard.this, MainActivity.class);
                        /*i.putExtra("pertanyaan", arrPertanyaan);
                        i.putExtra("kunci", arrKunci);
                        i.putExtra("hasil", arrHasil);*/
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
                Intent i = new Intent(SoalHard.this, MainActivity.class);
                        /*i.putExtra("pertanyaan", arrPertanyaan);
                        i.putExtra("kunci", arrKunci);
                        i.putExtra("hasil", arrHasil);*/
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void successs2(){
        epicDialog.setContentView(R.layout.popup_success2);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_nothing);
        crd.startAnimation(animation);

        btnOk = (Button) epicDialog.findViewById(R.id.btn_ok);
        btnClose = (ImageView) epicDialog.findViewById(R.id.btn_close);
        msg = (TextView) epicDialog.findViewById(R.id.message);
        title = (TextView) epicDialog.findViewById(R.id.tittle);
        pts =(TextView) epicDialog.findViewById(R.id.point);

        pts.setText(String.valueOf(jumBenarPG));

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
                Intent i = new Intent(SoalHard.this, MainActivity.class);
                        /*i.putExtra("pertanyaan", arrPertanyaan);
                        i.putExtra("kunci", arrKunci);
                        i.putExtra("hasil", arrHasil);*/
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
                Intent i = new Intent(SoalHard.this, MainActivity.class);
                        /*i.putExtra("pertanyaan", arrPertanyaan);
                        i.putExtra("kunci", arrKunci);
                        i.putExtra("hasil", arrHasil);*/
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void successs3(){
        epicDialog.setContentView(R.layout.popup_success3);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_nothing);
        crd.startAnimation(animation);

        btnOk = (Button) epicDialog.findViewById(R.id.btn_ok);
        btnClose = (ImageView) epicDialog.findViewById(R.id.btn_close);
        msg = (TextView) epicDialog.findViewById(R.id.message);
        title = (TextView) epicDialog.findViewById(R.id.tittle);
        pts =(TextView) epicDialog.findViewById(R.id.point);

        pts.setText(String.valueOf(jumBenarPG));

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
                Intent i = new Intent(SoalHard.this, MainActivity.class);
                        /*i.putExtra("pertanyaan", arrPertanyaan);
                        i.putExtra("kunci", arrKunci);
                        i.putExtra("hasil", arrHasil);*/
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
                Intent i = new Intent(SoalHard.this, MainActivity.class);
                        /*i.putExtra("pertanyaan", arrPertanyaan);
                        i.putExtra("kunci", arrKunci);
                        i.putExtra("hasil", arrHasil);*/
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void failed(){
        epicDialog.setContentView(R.layout.popup_failed);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.from_nothing);
        crd.startAnimation(animation);

        btnOk = (Button) epicDialog.findViewById(R.id.btn_ok);
        btnClose = (ImageView) epicDialog.findViewById(R.id.btn_close);
        msg = (TextView) epicDialog.findViewById(R.id.message);
        title = (TextView) epicDialog.findViewById(R.id.tittle);
        pts = (TextView) epicDialog.findViewById(R.id.point);

        pts.setText(String.valueOf(jumBenarPG));
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
                Intent i = new Intent(SoalHard.this, MainActivity.class);
                        /*i.putExtra("pertanyaan", arrPertanyaan);
                        i.putExtra("kunci", arrKunci);
                        i.putExtra("hasil", arrHasil);*/
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
                Intent i = new Intent(SoalHard.this, MainActivity.class);
                        /*i.putExtra("pertanyaan", arrPertanyaan);
                        i.putExtra("kunci", arrKunci);
                        i.putExtra("hasil", arrHasil);*/
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    public void konfirmasiA() {
        AlertDialog.Builder ad = new AlertDialog.Builder(SoalHard.this);
        ad.setMessage("Pilihan Anda 'A' ?");

        ad.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ke = ke + 1;

                if (ke >= jumsoal) {
                    onDestroy();
                    selesai();
                    /*Intent i = new Intent(Soal.this, MainActivity.class);
                    startActivity(i);
                    finish();
*/                } else {
                    lihat();

                }

            }
        });

        ad.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                /*radA.setChecked(true);
                radC.setChecked(false);                radB.setChecked(false);

                radD.setChecked(false);*/

            }
        });

        ad.show();
    }

    public void konfirmasiB() {
        AlertDialog.Builder ad = new AlertDialog.Builder(SoalHard.this);
        ad.setMessage("Pilihan Anda 'B' ?");

        ad.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ke = ke + 1;

                if (ke >= jumsoal) {
                    selesai();
                    onDestroy();
                    /*Intent i = new Intent(Soal.this, MainActivity.class);
                    startActivity(i);
                    finish();*/
                } else {
                    lihat();

                }
            }
        });

        ad.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                /*radA.setChecked(false);
                radB.setChecked(true);
                radC.setChecked(false);
                radD.setChecked(false);*/
            }
        });

        ad.show();
    }

    public void konfirmasiC() {
        AlertDialog.Builder ad = new AlertDialog.Builder(SoalHard.this);
        ad.setMessage("Pilihan Anda 'C' ?");

        ad.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ke = ke + 1;

                if (ke >= jumsoal) {
                    selesai();
                    onDestroy();
                    /*Intent i = new Intent(Soal.this, MainActivity.class);
                    startActivity(i);
                    finish();*/
                } else {
                    lihat();

                }
            }
        });

        ad.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                /*radA.setChecked(false);
                radB.setChecked(false);
                radC.setChecked(true);
                radD.setChecked(false);*/
            }
        });

        ad.show();
    }

    public void konfirmasiD() {
        AlertDialog.Builder ad = new AlertDialog.Builder(SoalHard.this);
        ad.setMessage("Pilihan Anda 'D' ?");

        ad.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ke = ke + 1;

                if (ke >= jumsoal) {
                    selesai();
                    onDestroy();
                    /*Intent i = new Intent(Soal.this, MainActivity.class);
                    startActivity(i);
                    finish();*/
                } else {
                    lihat();

                }
            }
        });

        ad.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                /*radA.setChecked(false);
                radB.setChecked(false);
                radC.setChecked(false);
                radD.setChecked(true);*/
            }
        });

        ad.show();
    }

    void pajakUmum1() {
        jd = 5;
        arr_idsoal = new String[jd];
        arr_pertanyaan = new String[jd];
        arr_jawabA = new String[jd];
        arr_jawabB = new String[jd];
        arr_jawabC = new String[jd];
        arr_jawabD = new String[jd];
        arr_jawabBenar = new String[jd];

        // soal-soal
        arr_idsoal[0] = "S01";
        arr_pertanyaan[0] = " Yang dimaksud dengan subjek pajak adalah sebagai berikut, kecuali...";
        arr_jawabA[0] = "A. Badan";
        arr_jawabB[0] = "B. Orang Pribadi";
        arr_jawabC[0] = "C. Warisan yang sudah terbagi";
        arr_jawabD[0] = "D. Bentuk usaha tetap";
        arr_jawabBenar[0] = "A";

        arr_idsoal[1] = "S02";
        arr_pertanyaan[1] = " Tarif untuk PPh Pasal 21 adalah...";
        arr_jawabA[1] = "A. 5%, 10%, 25%, 30% ";
        arr_jawabB[1] = "B. 5%, 15%, 25%, 30% ";
        arr_jawabC[1] = "C. 5%, 15%, 20%, 25% ";
        arr_jawabD[1] = "D. 5%, 15%, 25%, 35% ";
        arr_jawabBenar[1] = "A";

        arr_idsoal[2] = "S03";
        arr_pertanyaan[2] = " Syarat subyektif menjadi Wajib Pajak adalah... ";
        arr_jawabA[2] = "A. Bertempat tinggal di Indonesia lebih \ndari 183 hari selama 12 bulan";
        arr_jawabB[2] = "B. Bertempat tinggal di Indonesia lebih \ndari 180 hari selama 12 bulan";
        arr_jawabC[2] = "C. Bertempat tinggal di Indonesia tidak \nlebih dari 183 hari selama 12 bulan";
        arr_jawabD[2] = "D. Bertempat tinggal di Indonesia tidak \nlebih dari 180 hari selama 12 bulan";
        arr_jawabBenar[2] = "A";

        arr_idsoal[3] = "S04";
        arr_pertanyaan[3] = " Sanksi administrasi untuk keterlambatan \npelaporan SPT Masa PPh 21 adalah...";
        arr_jawabA[3] = "A. 50.000 rupiah";
        arr_jawabB[3] = "B. 500.000 rupiah";
        arr_jawabC[3] = "C. 1.000.000 rupiah";
        arr_jawabD[3] = "D. 100.000 rupiah";
        arr_jawabBenar[3] = "A";

        arr_idsoal[4] = "S05";
        arr_pertanyaan[4] = " Berapa jumlah maksimal tanggungan yang \n dapat dimasukkan ke dalam daftar anggota  keluarga dalam pelaporan Surat Pemberitahuan...  ";
        arr_jawabA[4] = "A. 2 ";
        arr_jawabB[4] = "B. 3 ";
        arr_jawabC[4] = "C. 1 ";
        arr_jawabD[4] = "D. 4 ";
        arr_jawabBenar[4] = "A";

        /*arr_idsoal[5] = "S06";
        arr_pertanyaan[5] = "  Jumlah Penghasilan Tidak Kena Pajak untuk Status Wajib Pajak Sudah  Menikah dengan 2 tanggungan adalah...";
        arr_jawabA[5] = "A. 54.000.000";
        arr_jawabB[5] = "B. 58.500.000";
        arr_jawabC[5] = "C. 63.000.000";
        arr_jawabD[5] = "D. 67.500.000";
        arr_jawabBenar[5] = "A";

        arr_idsoal[6] = "S07";
        arr_pertanyaan[6] = " Berikut adalah objek pajak penghasilan, kecuali... ";
        arr_jawabA[6] = "A. Laba usaha, warisan, royalti,\n premi asuransi";
        arr_jawabB[6] = "B. Surplus Bank Indonesia, dividen,\n hadiah undian dan penghargaan, laba usaha";
        arr_jawabC[6] = "C. Premi asuransi, imbalan bunga sesuai\n UU perpajakan, dividen  ";
        arr_jawabD[6] = "D. Penerimaan kembali pembayaran pajak,\n selisih lebih karena penilaian kembali aktiva";
        arr_jawabBenar[6] = "A";

        arr_idsoal[7] = "S08";
        arr_pertanyaan[7] = " Batas waktu penyampaian SPT Tahunan untuk WP Badan adalah ...    ";
        arr_jawabA[7] = "A. Empat bulan setelah berakhirnya\n Tahun Pajak";
        arr_jawabB[7] = "B. Tiga bulan setelah berakhirnya\n Tahun Pajak";
        arr_jawabC[7] = "C. Empat bulan sebelum berakhirnya\n Tahun Pajak";
        arr_jawabD[7] = "D. Tiga bulan sebelum berakhirnya\n Tahun Pajak";
        arr_jawabBenar[7] = "A";

        arr_idsoal[8] = "S09";
        arr_pertanyaan[8] = " Syarat mengajukan pendaftaran NPWP Orang Pribadi sesuai PMK‐147/PMK.03/2017  adalah ...  ";
        arr_jawabA[8] = "A. Mengisi formulir pendaftaran NPWP";
        arr_jawabB[8] = "B. Mengisi formulir pendaftaran NPWP,\n melampirkan fotokopi KTP";
        arr_jawabC[8] = "C. Mengisi formulir pendaftaran NPWP,\n melampirkan fotokopi KTP dan pasfoto";
        arr_jawabD[8] = "D. Mengisi formulir pendaftaran NPWP,\n melampirkan fotokopi KTP dan pasfoto,\n melampirkan bukti penghasilan";
        arr_jawabBenar[8] = "A";

        arr_idsoal[9] = "S10";
        arr_pertanyaan[9] = " Alamat penyampaian SPT Tahunan dalam bentuk elektronik dapat disampaikan kepada  DJP melalui...";
        arr_jawabA[9] = "A. efin.pajak.go.id";
        arr_jawabB[9] = "B. efiling.pajak.go.id";
        arr_jawabC[9] = "C. djponline.pajak.go.id";
        arr_jawabD[9] = "D. djp.pajak.go.id";
        arr_jawabBenar[9] = "A";*/
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            keluarYN();     //lari nya ke public void keluarYN
            return true;
        }
        return super.onKeyDown(keyCode, event);     //tombol back untuk kembali ke menu sebelumnya
    }


    public void keluarYN() {
        android.support.v7.app.AlertDialog.Builder ad = new android.support.v7.app.AlertDialog.Builder(SoalHard.this);
        ad.setTitle("Peringatan");
        ad.setMessage("Quiz harus diselesaikan!");

        ad.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                finish();      //keluar aplikasi
            }});

        /*ad.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });*/

        ad.show();
    }
}
