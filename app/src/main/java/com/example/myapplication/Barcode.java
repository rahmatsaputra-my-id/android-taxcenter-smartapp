package com.example.myapplication;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.qrcode.encoder.QRCode;

import androidmads.library.qrgenearator.QRGEncoder;

public class Barcode extends AppCompatActivity {

    String TAG="GenerateCode";
    Bitmap bitmap;
    QRGEncoder qrgEncoder;
    TextView txtView;
    ImageView qrimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

        txtView =(TextView) findViewById(R.id.namanya);
        qrimage =(ImageView) findViewById(R.id.qrcode);
    }
}
