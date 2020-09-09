package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import java.util.Calendar;
import java.util.Random;

public class NPWP extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spnr2;

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

    private EditText date;
    private CheckBox ckls;
    private Button sbmt;
    private DatePickerDialog.OnDateSetListener setListener;
    RadioGroup rdbtnc,rdbtna;
    ExpandableLinearLayout expand21,expand22,expand42,expandLayout1,expandLayout2,expandLayout3,expandLayout4,expandLayout5,expandLayout6,expandLayout7,expandLayout8,expandLayout9,expandLayout10;

    EditText edtNamaDepan,edtNamaBelakang,edtJalan,edtBlok,edtNIK,edtNomor,edtRT,edtRW,edtKelurahan,edtKecamatan,edtKota,edtProvinsi;

    String stNamaDepan,stNamaBelakang,stJalan,stBlok,stNIK,stNomor,stRT,stRW, stKelurahan,stKecamatan,stKota,stProvinsi,strnd1,strnd2,strnd3, strnd4,stStatus,stKode_wlyh;

    TextView tv_rnd1,tv_rnd2,tv_rnd3, tv_rnd4,tv_kdWlyh;

    TextInputLayout TIL_namaDepan,TIL_namaBelakang,TIL_NIK, TIL_Jalan, TIL_Blok, TIL_Nomor, TIL_RT, TIL_RW, TIL_Kelurahan, TIL_Kecamatan, TIL_Kota, TIL_Provinsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npwp);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        date=findViewById(R.id.Date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        NPWP.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String waktunya = day+"/"+month+"/"+year;
                        date.setText(waktunya);
                    }
                },year,month,day);
                        datePickerDialog.show();
            }
        });

        ckls=findViewById(R.id.ceklis);
        sbmt=findViewById(R.id.submit);

        ckls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ckls.isChecked()) {
                    sbmt.setEnabled(true);
                } else {
                    sbmt.setEnabled(false);
                }
            }
        });

        edtNamaDepan = findViewById(R.id.etNamaDepan);
        edtNamaBelakang = findViewById(R.id.etNamaBelakang);
        edtJalan = findViewById(R.id.etJalan);
        edtBlok = findViewById(R.id.etBlok);
        edtNIK = findViewById(R.id.etNIK);
        edtNomor = findViewById(R.id.etNomor);
        edtRT= findViewById(R.id.etRT);
        edtRW= findViewById(R.id.etRW);
        edtKelurahan= findViewById(R.id.etKelurahan);
        edtKecamatan= findViewById(R.id.etKecamatan);
        edtKota= findViewById(R.id.etKota);
        edtProvinsi= findViewById(R.id.etProvinsi);
        tv_rnd1 = findViewById(R.id.rnd1);
        tv_rnd2 = findViewById(R.id.rnd2);
        tv_rnd3 = findViewById(R.id.rnd3);
        tv_rnd4 = findViewById(R.id.rnd4);

        final Random myRandom = new Random();

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent i = new Intent(NPWP.this, HasilNpwp.class);

                stNamaDepan=edtNamaDepan.getText().toString();
                i.putExtra("Value",stNamaDepan);

                stNamaBelakang=edtNamaBelakang.getText().toString();
                i.putExtra("Value1",stNamaBelakang);

                stJalan=edtJalan.getText().toString();
                i.putExtra("Value2",stJalan);

                stBlok=edtBlok.getText().toString();
                i.putExtra("Value3",stBlok);

                stNIK=edtNIK.getText().toString();
                i.putExtra("Value4",stNIK);

                stNomor=edtNomor.getText().toString();
                i.putExtra("Value5",stNomor);

                stRT=edtRT.getText().toString();
                i.putExtra("Value6",stRT);

                stRW=edtRW.getText().toString();
                i.putExtra("Value7",stRW);

                stKelurahan=edtKelurahan.getText().toString();
                i.putExtra("Value8",stKelurahan);

                stKecamatan=edtKecamatan.getText().toString();
                i.putExtra("Value9",stKecamatan);

                stKota=edtKota.getText().toString();
                i.putExtra("Value10",stKota);

                stProvinsi=edtProvinsi.getText().toString();
                i.putExtra("Value11",stProvinsi);

                int value = myRandom.nextInt(99 - 10) +10;
                tv_rnd1.setText(String.valueOf(value));

                int value2 = myRandom.nextInt(999 - 100) +100;
                tv_rnd2.setText(String.valueOf(value2));

                int value3 = myRandom.nextInt(999 - 100) +100;
                tv_rnd3.setText(String.valueOf(value3));

                int value4 = myRandom.nextInt(9 - 1) +1;
                tv_rnd4.setText(String.valueOf(value4));

                strnd1= tv_rnd1.getText().toString();
                i.putExtra("Value12",strnd1);

                strnd2= tv_rnd2.getText().toString();
                i.putExtra("Value13",strnd2);

                strnd3= tv_rnd3.getText().toString();
                i.putExtra("Value14",strnd3);

                strnd4= tv_rnd4.getText().toString();
                i.putExtra("Value15",strnd4);

                RadioButton rb_pus = findViewById(R.id.rb_pusat);
                RadioButton rb_cab = findViewById(R.id.rb_cabang);
                TextView tv_stat = findViewById(R.id.tv_status);

                if (rb_pus.isChecked() == true){
                    tv_stat.setText("000");
                } else if (rb_cab.isChecked() == true){
                    tv_stat.setText("001");
                }

                stStatus = tv_stat.getText().toString();
                i.putExtra("Value16",stStatus);

                stKode_wlyh = tv_kdWlyh.getText().toString();
                i.putExtra("Value17",stKode_wlyh);

                TIL_namaDepan = findViewById(R.id.lyt_namaDepan);
                TIL_namaBelakang = findViewById(R.id.lyt_namaBelakang);
                TIL_NIK = findViewById(R.id.lyt_nik);
                TIL_Jalan = findViewById(R.id.lyt_jalan);
                TIL_Blok = findViewById(R.id.lyt_blok);
                TIL_Nomor = findViewById(R.id.lyt_nomor);
                TIL_RT = findViewById(R.id.lyt_rt);
                TIL_RW = findViewById(R.id.lyt_rw);
                TIL_Kelurahan = findViewById(R.id.lyt_kelurahan);
                TIL_Kecamatan = findViewById(R.id.lyt_kecamatan);
                TIL_Kota = findViewById(R.id.lyt_kota);
                TIL_Provinsi = findViewById(R.id.lyt_provinsi);

                if(!validateNamadepan() | !validateNamaBelakang() | !validateNIK()){
                    expandLayout3.toggle();
                    expandLayout2.collapse();
                    expandLayout1.collapse();
                    expandLayout4.collapse();
                    expandLayout5.collapse();
                    expandLayout6.collapse();
                    expandLayout7.collapse();
                    expandLayout8.collapse();
                    expandLayout9.collapse();
                    return;
                }

                if(!validateJalan() | !validateBlok() | !validateNomor() | !validateRT() | !validateRW() | !validateKelurahan() | !validateKecamatan() | !validateKota() | !validateProvinsi()){
                    expandLayout6.toggle();
                    expandLayout2.collapse();
                    expandLayout1.collapse();
                    expandLayout4.collapse();
                    expandLayout3.collapse();
                    expandLayout5.collapse();
                    expandLayout7.collapse();
                    expandLayout8.collapse();
                    expandLayout9.collapse();
                    return;
                }

//                spnr2 = findViewById(R.id.spinner2);
//
//                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(NPWP.this, R.array.kd_wilayah, android.R.layout.simple_spinner_item);
//                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//                spnr2.setAdapter(adapter);
//
//                spnr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
////                Toast.makeText(NPWP.this,spnr2.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
//                        tv_kdWlyh = findViewById(R.id.kd_wilayah);
//
//                        if (position == 0 ){
////                            Toast.makeText(NPWP.this,"Silahkan Pilih Kode Wilayah",Toast.LENGTH_LONG).show();
//                            expandLayout6.toggle();
//                            expandLayout2.collapse();
//                            expandLayout1.collapse();
//                            expandLayout4.collapse();
//                            expandLayout3.collapse();
//                            expandLayout5.collapse();
//                            expandLayout7.collapse();
//                            expandLayout8.collapse();
//                            expandLayout9.collapse();
//
//                            TextView errorText = (TextView)spnr2.getSelectedView();
//                            errorText.setError("");
//                            errorText.setTextSize(12);
//                            errorText.setTextColor(Color.RED);//just to highlight that this is an error
//                            errorText.setText("-- Silahkan Pilih --");//changes the selected item text to this
//
//                        }else {
//                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivity(i);
//                        }
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> adapterView) {
//
//                    }
//                });

                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        Spinner spnr = findViewById(R.id.spinner);
        final Spinner spnr2 = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kd_wilayah, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnr.setAdapter(adapter);
        spnr2.setAdapter(adapter);

        /*Toast yang dipilih*/
//        spnr.setOnItemSelectedListener(this);
//        spnr2.setOnItemSelectedListener(this);
        spnr2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                tv_kdWlyh = findViewById(R.id.kd_wilayah);

                if (position == 0 ){
                    tv_kdWlyh.setText("403");
                } else if (position == 1 ){
                    tv_kdWlyh.setText("404");
                } else if (position == 2){
                    tv_kdWlyh.setText("407");
                } else if (position == 3){
                    tv_kdWlyh.setText("412");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                expandLayout6.toggle();
                expandLayout2.collapse();
                expandLayout1.collapse();
                expandLayout4.collapse();
                expandLayout3.collapse();
                expandLayout5.collapse();
                expandLayout7.collapse();
                expandLayout8.collapse();
                expandLayout9.collapse();

                TextView errorText = (TextView)spnr2.getSelectedView();
                errorText.setError("");
                errorText.setTextSize(12);
                errorText.setTextColor(Color.RED);//just to highlight that this is an error
                errorText.setText("-- Silahkan Pilih --");//changes the selected item text to this

            }
        });

        rdbtnc= (RadioGroup) findViewById(R.id.rgc);
        rdbtna= (RadioGroup) findViewById(R.id.rga);

        rdbtnc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != R.id.rbtn9){
                    expand42 = (ExpandableLinearLayout) findViewById(R.id.expandLayout42);
                    expand42.collapse();
                } else if (checkedId == R.id.rbtn9){
                    expand42 = (ExpandableLinearLayout) findViewById(R.id.expandLayout42);
                    expand42.toggle();
                }
            }
        });

        rdbtna.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != R.id.rba1){
                    expand22 = (ExpandableLinearLayout) findViewById(R.id.expandLayout22);
                    expand21 = (ExpandableLinearLayout) findViewById(R.id.expandLayout21);
                    expand21.collapse();
                    expand22.toggle();
                } else if (checkedId == R.id.rba1){
                    expand21 = (ExpandableLinearLayout) findViewById(R.id.expandLayout21);
                    expand22 = (ExpandableLinearLayout) findViewById(R.id.expandLayout22);
                    expand22.collapse();
                    expand21.toggle();
                }
            }
        });
    }

    private boolean validateNamadepan(){

        String err_edtNamadepan = TIL_namaDepan.getEditText().getText().toString().trim();

        if (err_edtNamadepan.isEmpty()){
            edtNamaDepan.setError("Field Can't Blank");
            return false;
        }else{
            TIL_namaDepan.setError(null);
            return true;
        }
    }

    private boolean validateNamaBelakang(){

        String err_edtNamaBelakang = TIL_namaBelakang.getEditText().getText().toString().trim();

        if (err_edtNamaBelakang.isEmpty()){
            edtNamaBelakang.setError("Field Can't Blank");
            return false;
        }else{
            TIL_namaBelakang.setError(null);
            return true;
        }
    }

    private boolean validateNIK(){

        String err_edtNIK= TIL_NIK.getEditText().getText().toString().trim();

        if (err_edtNIK.isEmpty()){
            edtNIK.setError("Field Can't Blank");
            return false;
        }else{
            TIL_NIK.setError(null);
            return true;
        }
    }

    private boolean validateJalan(){

        String err_edtJalan= TIL_Jalan.getEditText().getText().toString().trim();

        if (err_edtJalan.isEmpty()){
            edtJalan.setError("Field Can't Blank");
            return false;
        }else{
            TIL_Jalan.setError(null);
            return true;
        }
    }

    private boolean validateBlok(){

        String err_edtBlok= TIL_Blok.getEditText().getText().toString().trim();

        if (err_edtBlok.isEmpty()){
            edtBlok.setError("Field Can't Blank");
            return false;
        }else{
            TIL_Blok.setError(null);
            return true;
        }
    }

    private boolean validateNomor(){

        String err_edtNomor= TIL_Nomor.getEditText().getText().toString().trim();

        if (err_edtNomor.isEmpty()){
            edtNomor.setError("Field Can't Blank");
            return false;
        }else{
            TIL_Nomor.setError(null);
            return true;
        }
    }

    private boolean validateRT(){

        String err_edtRT= TIL_RT.getEditText().getText().toString().trim();

        if (err_edtRT.isEmpty()){
            edtRT.setError("Field Can't Blank");
            return false;
        }else{
            TIL_RT.setError(null);
            return true;
        }
    }

    private boolean validateRW(){

        String err_edtRW= TIL_RW.getEditText().getText().toString().trim();

        if (err_edtRW.isEmpty()){
            edtRW.setError("Field Can't Blank");
            return false;
        }else{
            TIL_RW.setError(null);
            return true;
        }
    }

    private boolean validateKelurahan(){

        String err_edtKelurahan= TIL_Kelurahan.getEditText().getText().toString().trim();

        if (err_edtKelurahan.isEmpty()){
            edtKelurahan.setError("Field Can't Blank");
            return false;
        }else{
            TIL_Kelurahan.setError(null);
            return true;
        }
    }

    private boolean validateKecamatan(){

        String err_edtKecamatan= TIL_Kecamatan.getEditText().getText().toString().trim();

        if (err_edtKecamatan.isEmpty()){
            edtKecamatan.setError("Field Can't Blank");
            return false;
        }else{
            TIL_Kecamatan.setError(null);
            return true;
        }
    }

    private boolean validateKota(){

        String err_edtKota= TIL_Kota.getEditText().getText().toString().trim();

        if (err_edtKota.isEmpty()){
            edtKota.setError("Field Can't Blank");
            return false;
        }else{
            TIL_Kota.setError(null);
            return true;
        }
    }

    private boolean validateProvinsi(){

        String err_edtProvinsi= TIL_Provinsi.getEditText().getText().toString().trim();

        if (err_edtProvinsi.isEmpty()){
            edtProvinsi.setError("Field Can't Blank");
            return false;
        }else{
            TIL_Provinsi.setError(null);
            return true;
        }
    }

    public void expandButton1 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout1.toggle();
        expandLayout2.collapse();
        expandLayout3.collapse();
        expandLayout4.collapse();
        expandLayout5.collapse();
        expandLayout6.collapse();
        expandLayout7.collapse();
        expandLayout8.collapse();
        expandLayout9.collapse();
    }

    public void expandButton2 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout2.toggle();
        expandLayout1.collapse();
        expandLayout3.collapse();
        expandLayout4.collapse();
        expandLayout5.collapse();
        expandLayout6.collapse();
        expandLayout7.collapse();
        expandLayout8.collapse();
        expandLayout9.collapse();
    }

    public void expandButton3 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout3.toggle();
        expandLayout2.collapse();
        expandLayout1.collapse();
        expandLayout4.collapse();
        expandLayout5.collapse();
        expandLayout6.collapse();
        expandLayout7.collapse();
        expandLayout8.collapse();
        expandLayout9.collapse();
    }

    public void expandButton4 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout4.toggle();
        expandLayout2.collapse();
        expandLayout3.collapse();
        expandLayout1.collapse();
        expandLayout5.collapse();
        expandLayout6.collapse();
        expandLayout7.collapse();
        expandLayout8.collapse();
        expandLayout9.collapse();
    }

    public void expandButton5 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout5.toggle();
        expandLayout2.collapse();
        expandLayout3.collapse();
        expandLayout4.collapse();
        expandLayout1.collapse();
        expandLayout6.collapse();
        expandLayout7.collapse();
        expandLayout8.collapse();
        expandLayout9.collapse();
    }

    public void expandButton6 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout6.toggle();
        expandLayout2.collapse();
        expandLayout3.collapse();
        expandLayout4.collapse();
        expandLayout5.collapse();
        expandLayout1.collapse();
        expandLayout7.collapse();
        expandLayout8.collapse();
        expandLayout9.collapse();
    }

    public void expandButton7 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout7.toggle();
        expandLayout2.collapse();
        expandLayout3.collapse();
        expandLayout4.collapse();
        expandLayout5.collapse();
        expandLayout6.collapse();
        expandLayout1.collapse();
        expandLayout8.collapse();
        expandLayout9.collapse();
    }

    public void expandButton8 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout8.toggle();
        expandLayout2.collapse();
        expandLayout3.collapse();
        expandLayout4.collapse();
        expandLayout5.collapse();
        expandLayout6.collapse();
        expandLayout7.collapse();
        expandLayout1.collapse();
        expandLayout9.collapse();
    }

    public void expandButton9 (View view){
        expandLayout1 = (ExpandableLinearLayout) findViewById(R.id.expandLayout1);
        expandLayout2 = (ExpandableLinearLayout) findViewById(R.id.expandLayout2);
        expandLayout3 = (ExpandableLinearLayout) findViewById(R.id.expandLayout3);
        expandLayout4 = (ExpandableLinearLayout) findViewById(R.id.expandLayout4);
        expandLayout5 = (ExpandableLinearLayout) findViewById(R.id.expandLayout5);
        expandLayout6 = (ExpandableLinearLayout) findViewById(R.id.expandLayout6);
        expandLayout7 = (ExpandableLinearLayout) findViewById(R.id.expandLayout7);
        expandLayout8 = (ExpandableLinearLayout) findViewById(R.id.expandLayout8);
        expandLayout9 = (ExpandableLinearLayout) findViewById(R.id.expandLayout9);
        expandLayout9.toggle();
        expandLayout2.collapse();
        expandLayout3.collapse();
        expandLayout4.collapse();
        expandLayout5.collapse();
        expandLayout6.collapse();
        expandLayout7.collapse();
        expandLayout8.collapse();
        expandLayout1.collapse();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            keluarYN();     //lari nya ke public void keluarYN
            return true;
        }
        return super.onKeyDown(keyCode, event);     //tombol back untuk kembali ke menu sebelumnya
    }


    public void keluarYN() {
        android.support.v7.app.AlertDialog.Builder ad = new android.support.v7.app.AlertDialog.Builder(NPWP.this);
        ad.setTitle("Peringatan");
        ad.setMessage("Anda Yakin? Data belum di simpan!");

        ad.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(NPWP.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

        ad.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });

        ad.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
