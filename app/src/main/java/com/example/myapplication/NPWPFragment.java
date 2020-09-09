package com.example.myapplication;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NPWPFragment extends Fragment {


    public NPWPFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Skema NPWP");
        View view = inflater.inflate(R.layout.fragment_npwp, container, false);

        Button btndaftar= (Button) view.findViewById(R.id.btn_daftar);
        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts = new Intent(getActivity(),ProsedurNPWP.class);
                startActivity(starts);
            }
        });

        ImageView img = (ImageView) view.findViewById(R.id.gambarView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ereg = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ereg.pajak.go.id/login"));
                ereg.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(ereg);
            }
        });

        return view;
    }

}
