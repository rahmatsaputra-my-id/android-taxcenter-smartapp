package com.example.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    SpaceNavigationView navigationView;

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

    public void Banner(){
        epicDialog.setContentView(R.layout.popup_banner);

        CardView crd = (CardView) epicDialog.findViewById(R.id.card);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.forloci);
        crd.startAnimation(animation);

        btnClose = (ImageView) epicDialog.findViewById(R.id.btn_close);

        crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent starts = new Intent(MainActivity.this,WalkthroughNpwp.class);
                startActivity(starts);
                starts.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                epicDialog.dismiss();
//                Intent i = new Intent(MainActivity.this, MainActivity.class);
//                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(i);
//                finish();
            }
        });

        epicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        epicDialog.setCancelable(false);
        epicDialog.show();
    }

    ImageView btnClose;
    Dialog epicDialog;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1,floatingActionButton2,floatingActionButton3,floatingActionButton4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new HomeFragment());

        epicDialog = new Dialog(this);
//        Banner();

        materialDesignFAM = (FloatingActionMenu)findViewById(R.id.social_floating_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.floating_facebook);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.floating_youtube);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.floating_instagram);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                Intent facebookIntent = getOpenFacebookIntent(MainActivity.this);
                startActivity(facebookIntent);

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                Intent youtubeIntent = getOpenYouTubeIntent(MainActivity.this);
                startActivity(youtubeIntent);

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                Intent instagramIntent = getOpenInstagramIntent(MainActivity.this);
                startActivity(instagramIntent);
            }
        });


        /*getSupportActionBar().setLogo(R.drawable.logo3);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);*/

        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        navigationView = findViewById(R.id.space);
        navigationView.initWithSaveInstanceState(savedInstanceState);

        navigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.ic_home_black_24dp));
        navigationView.addSpaceItem(new SpaceItem("QUIZ", R.drawable.ic_videogame_asset_black_24dp));
//        navigationView.addSpaceItem(new SpaceItem("FORUM", R.drawable.ic_question_answer_black_24dp));
//        navigationView.addSpaceItem(new SpaceItem("PROFILE", R.drawable.ic_person_black_24dp));

        navigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(MainActivity.this,"SKEMA NPWP", Toast.LENGTH_SHORT).show();
                navigationView.setCentreButtonSelectable(true);
                loadFragment(new NPWPFragment());
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, itemName, Toast.LENGTH_SHORT).show();
                if (itemIndex == 0){
                    loadFragment(new HomeFragment());
                } else if (itemIndex == 1){
                    loadFragment(new QuizFragment());
                } else if (itemIndex == 2){
                    loadFragment(new ForumFragment());
                } else if (itemIndex == 3){
                    loadFragment(new ProfileFragment());
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, itemName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.view_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://id-id.facebook.com/taxcentergunadarmauniversity/")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://id-id.facebook.com/taxcentergunadarmauniversity/")); //catches and opens a url to the desired page
        }
    }

    public static Intent getOpenInstagramIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.instagram.android", 0); //Checks if Instagram is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/taxcenter.ug/?hl=id")); //Trys to make intent with Instagram's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/taxcenter.ug/?hl=id")); //catches and opens a url to the desired page
        }
    }

    public static Intent getOpenYouTubeIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.google.android.youtube", 0); //Checks if YT is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/channel/UCv-yixvyDOUX5zRDDh7gxjQ")); //Trys to make intent with YT's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.youtube.com/channel/UCv-yixvyDOUX5zRDDh7gxjQ")); //catches and opens a url to the desired page
        }
    }

    public void onBackPressed(){
        Intent setIntent = new Intent(Intent.ACTION_MAIN);
        setIntent.addCategory(Intent.CATEGORY_HOME);
        setIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(setIntent);
    }
}
