package com.example.myapplication;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ViewPager viewPager;
    ExpandableLinearLayout expandlayout1;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Smart Tax");
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        /*getSupportActionBar().setDisplayShowTitleEnabled(false);*/


//        Button btnReg = (Button) view.findViewById(R.id.btnDaftar);
//        btnReg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent regis = new Intent(Intent.ACTION_VIEW, Uri.parse("https://taxcenter.gunadarma.ac.id/kursus/index/registrasi"));
//                regis.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(regis);
//            }
//        });

        Button btnPjk = (Button) view.findViewById(R.id.btnPajak);
        btnPjk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pengertianPajak = new Intent(getActivity(),WalkthroughNpwp.class);
                pengertianPajak.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(pengertianPajak);
            }
        });

        Button btnMateriPjk = (Button) view.findViewById(R.id.btnMateriPajak);
        btnMateriPjk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnMateriPjk = new Intent(getActivity(),InklusiMenu.class);
                btnMateriPjk.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(btnMateriPjk);
            }
        });

        Button btnInklusi = (Button) view.findViewById(R.id.btnPengertianInklusi);
        btnInklusi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnInklusi = new Intent(getActivity(),OpeningQuiz.class);
                btnInklusi.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(btnInklusi);
            }
        });

        Button btnMateriinkls = (Button) view.findViewById(R.id.btnMateriInklusi);
        btnMateriinkls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnMateriinkls = new Intent(getActivity(),Penjelasan_Npwp.class);
                btnMateriinkls.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(btnMateriinkls);
            }
        });
//        ImageView logo1 = (ImageView)  view.findViewById(R.id.logo1);
//        logo1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent logo1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCv-yixvyDOUX5zRDDh7gxjQ"));
//                logo1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(logo1);
//            }
//        });
//
//        ImageView logo2 = (ImageView)  view.findViewById(R.id.logo2);
//        logo2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent logo2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/taxcenter.ug/"));
//                logo2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(logo2);
//            }
//        });
//
//        ImageView logo3 = (ImageView)  view.findViewById(R.id.logo3);
//        logo3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent logo3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://id-id.facebook.com/taxcentergunadarmauniversity/"));
//                logo3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(logo3);
//            }
//        });
//
//        ImageView logo4 = (ImageView)  view.findViewById(R.id.logo4);
//        logo4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent logo4 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCv-yixvyDOUX5zRDDh7gxjQ"));
//                logo4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(logo4);
//            }
//        });
//
//        CardView cardView = (CardView) view.findViewById(R.id.card1);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent cardView = new Intent(getActivity(),Inklusi.class);
//                startActivity(cardView);
//            }
//        });


        // Inflate the layout for this fragment
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());

        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 3000);

        return view;

    }

    public class MyTimerTask extends TimerTask{

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        public void run(){

            if(getActivity()!=null) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if (viewPager.getCurrentItem() == 0) {
                            viewPager.setCurrentItem(1);
                        } else if (viewPager.getCurrentItem() == 1) {
                            viewPager.setCurrentItem(2);
                        } else if (viewPager.getCurrentItem() == 2) {
                            viewPager.setCurrentItem(3);
                        } else if (viewPager.getCurrentItem() == 3) {
                            viewPager.setCurrentItem(4);
                        } else if (viewPager.getCurrentItem() == 4) {
                            viewPager.setCurrentItem(5);
                        }else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }

}
