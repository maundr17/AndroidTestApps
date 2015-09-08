package com.maundr17.soundbox;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button playButton;
    private Button prevButton;
    private Button nextButton;

    private MediaPlayer player;

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = new MediaPlayer();
        player = MediaPlayer.create(getApplicationContext(), R.raw.game_field);

        text = (TextView) findViewById(R.id.artistName);

        playButton = (Button) findViewById(R.id.playButton);
        prevButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        playButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.playButton:
                if(player.isPlaying()) {
                    pauseMusic();
                } else {
                    playMusic();
                }
                break;
            case R.id.prevButton:
                // do something
                break;
            case R.id.nextButton:
                // do something
                break;
        }
    }

    public void playMusic() {
        if(player != null) {
            player.start();
            text.setText("Music is playing now...");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_pause));
        }
    }

    public void pauseMusic() {
        if(player != null) {
            player.pause();
            text.setText("Music Paused");
            playButton.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_media_play));
        }
    }

    public void prevMusic() {

    }

    public void nextMusic() {

    }

    @Override
    public void onDestroy() {
        if(player != null && player.isPlaying()) {
            player.stop();
            player.release();
            player = null;
        }
        super.onDestroy();

    }
}

