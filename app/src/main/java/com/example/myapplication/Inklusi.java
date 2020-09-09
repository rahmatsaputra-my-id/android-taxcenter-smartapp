package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Vector;

public class Inklusi extends AppCompatActivity /*implements YouTubePlayer.OnInitializedListener */{

   /* public static final String DEVELOPER_KEY = "AIzaSyCe6tORd9Ch4lx-9Ku5SQ476uS9OtZYsWA";
    public static final String VIDEO_ID = "srH-2pQdKhg";
    public static final int RECOVERY_DIALOG_REQUEST = 1;

    YouTubePlayerFragment myYoutubePlayerFragment;
*/
   RecyclerView recyclerView,recyclerView2,recyclerView3,recyclerView4;
   Vector<YouTubeVideos> youTubeVideos = new Vector<>();
   Vector<YouTubeVideos> youTubeVideos2 = new Vector<>();
   Vector<YouTubeVideos> youTubeVideos3 = new Vector<>();
   Vector<YouTubeVideos> youTubeVideos4 = new Vector<>();
    @Override

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inklusi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView3 = (RecyclerView) findViewById(R.id.recyclerView3);
        recyclerView4 = (RecyclerView) findViewById(R.id.recyclerView4);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        recyclerView4.setHasFixedSize(true);
        recyclerView4.setLayoutManager(new LinearLayoutManager(this));

        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/6Xhb5yzrcmk\" frameborder=\"0\" allowfullscreen></iframe>"));
        youTubeVideos2.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qQta5HaRm9s\" ></iframe>"));
        youTubeVideos3.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/mgFlHqt2HA4\" frameborder=\"0\" allowfullscreen></iframe>"));
        youTubeVideos4.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eOd99pszKh8\" ></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youTubeVideos);
        VideoAdapter videoAdapter2 = new VideoAdapter(youTubeVideos2);
        VideoAdapter videoAdapter3 = new VideoAdapter(youTubeVideos3);
        VideoAdapter videoAdapter4 = new VideoAdapter(youTubeVideos4);

        recyclerView.setAdapter(videoAdapter);
        recyclerView.setAdapter(videoAdapter);

        recyclerView2.setAdapter(videoAdapter2);
        recyclerView2.setAdapter(videoAdapter2);

        recyclerView3.setAdapter(videoAdapter3);
        recyclerView3.setAdapter(videoAdapter3);

        recyclerView4.setAdapter(videoAdapter4);
        recyclerView4.setAdapter(videoAdapter4);


    }

    /*@Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored){
            player.cueVideo(VIDEO_ID);
        }
    }

    public void  onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == RECOVERY_DIALOG_REQUEST){
            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtubeplayerfragment);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if(errorReason.isUserRecoverableError()){
            errorReason.getErrorDialog(this,RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    "Ada yang salah pas initialisasi (%1$s)",
                    errorReason.toString());
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
        }
    }*/
}
