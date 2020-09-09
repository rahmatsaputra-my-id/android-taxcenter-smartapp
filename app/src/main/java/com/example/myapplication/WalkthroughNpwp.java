package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WalkthroughNpwp extends AppCompatActivity {

    private ViewPager   mSlideViewPager;
    private LinearLayout mLinearLayout;
    private WalkthroughAdapter walkthroughAdapter;
    private Button mNextBtn;
    private Button mBackBtn;

    private int mCurrentPage;
    private TextView[] mDots;
    private LinearLayout mDotsLayout;

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
        setContentView(R.layout.activity_walkthrough_npwp);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
//        mDotLayout = (LinearLayout) findViewById(R.id.dotLayout);
        mNextBtn = (Button) findViewById(R.id.wk_Next);
        mBackBtn = (Button) findViewById(R.id.wk_Back);
        mDotsLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        walkthroughAdapter = new WalkthroughAdapter(this);

        mSlideViewPager.setAdapter(walkthroughAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage+1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideViewPager.setCurrentItem(mCurrentPage-1);
            }
        });

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            mCurrentPage=i;
            if(i==0){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("");

            } else if( i == mDots.length -1 ){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Finish");
                if(mNextBtn.getText().equals("Finish") & i == mDots.length -1){
                    mNextBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent btnMateriinkls = new Intent(WalkthroughNpwp.this,MainActivity.class);
                            btnMateriinkls.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(btnMateriinkls);
                        }
                    });
                }

            }
            else {
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.INVISIBLE);
                mNextBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void addDotsIndicator(int position){
        mDots = new TextView[14];
        mDotsLayout.removeAllViews();


        for(int i=0; i<mDots.length;i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.Black));

            mDotsLayout.addView(mDots[i]);

        }

        if(mDots.length >0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
        }
    }

    public void onBackPressed(){
        Intent starts = new Intent(WalkthroughNpwp.this,MainActivity.class);
        startActivity(starts);
        starts.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
}
