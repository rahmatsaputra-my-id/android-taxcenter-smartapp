package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

import org.w3c.dom.Text;

public class WalkthroughAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public WalkthroughAdapter(Context context){
        this.context = context;
    }

    public int[] slides_images={
            R.drawable.pajak1,
            R.drawable.pajak2,
            R.drawable.pajak3,
            R.drawable.pajak4,
            R.drawable.pajak5,
            R.drawable.pajak6,
            R.drawable.pajak7,
            R.drawable.pajak8,
            R.drawable.pajak9,
            R.drawable.pajak10,
            R.drawable.pajak11,
            R.drawable.pajak12,
            R.drawable.pajak13,
            R.drawable.pajak14
    };

    public String[] slide_head = {
            "",
            "Penyerahan Berkas",
            "Datang ke Kantor Pelayanan Pajak(KPP) Terdekat",
            "Isi Lengkap Formulir Pengajuan NPWP",
            "Serahkan Berkas ke Petugas Pendaftaran",
            "",
            "Penyerahan Berkas",
            "Datang ke Kantor Pelayanan Pajak(KPP) Terdekat",
            "Isi Lengkap Formulir Pengajuan NPWP",
            "Serahkan Berkas ke Petugas Pendaftaran",
            "",
            "Penyerahan Berkas",
            "Datang ke Kantor Pelayanan Pajak(KPP) Terdekat",
            "Isi Lengkap Formulir Pengajuan NPWP"
    };

    public String[] slide_descs = {
            "",
            "Penyerahan Berkas",
            "Datang ke Kantor Pelayanan Pajak(KPP) Terdekat",
            "Isi Lengkap Formulir Pengajuan NPWP",
            "Serahkan Berkas ke Petugas Pendaftaran",
            "",
            "Penyerahan Berkas",
            "Datang ke Kantor Pelayanan Pajak(KPP) Terdekat",
            "Isi Lengkap Formulir Pengajuan NPWP",
            "Serahkan Berkas ke Petugas Pendaftaran",
            "",
            "Penyerahan Berkas",
            "Datang ke Kantor Pelayanan Pajak(KPP) Terdekat",
            "Isi Lengkap Formulir Pengajuan NPWP"
    };


    @Override
    public int getCount() {
        return slide_head.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.walkthrough_slide,container, false);

        PhotoView slideImageView = (PhotoView) view.findViewById(R.id.slide_image);
        TextView slideHead = (TextView) view.findViewById(R.id.slide_head);
        TextView slideDescs = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slides_images[position]);
        slideHead.setText(slide_head[position]);
        slideDescs.setText(slide_descs[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
