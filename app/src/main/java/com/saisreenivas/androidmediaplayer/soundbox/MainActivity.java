package com.saisreenivas.androidmediaplayer.soundbox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button playMusic;
    private Button prevMusic;
    private Button nextMusic;
    private TextView text;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.donu_donu);

        text = (TextView) findViewById(R.id.artistName);
        playMusic = (Button) findViewById(R.id.playBtn);
        prevMusic = (Button) findViewById(R.id.prevBtn);
        nextMusic = (Button) findViewById(R.id.nextBtn);

        playMusic.setOnClickListener(this);
        prevMusic.setOnClickListener(this);
        nextMusic.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playBtn:
                if(mediaPlayer.isPlaying()){
                    pauseMusic();
                }else {
                    startMusic();
                }
                break;
            case R.id.prevBtn:
                prevMusic();
                break;
            case R.id.nextBtn:
                nextMusic();
                break;
        }
    }

    public void startMusic(){
        mediaPlayer.start();
        text.setText("Music is playing...");
        playMusic.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
    }

    public void pauseMusic(){
        mediaPlayer.pause();
        text.setText("Music paused.");
        playMusic.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
    }

    public void prevMusic(){

    }

    public void nextMusic(){

    }
}
