package com.maundr17.playmusic;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Button playButton;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.game_field);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                int duration = mp.getDuration() / 1000 ;
                Toast.makeText(getApplicationContext(), "Duration: " + duration + " seconds", Toast.LENGTH_SHORT).show();
                playButton.setText("Play");
            }
        });

        playButton = (Button) findViewById(R.id.playButtonId);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()) {
                    // stop and give option to play again
                    pauseMusic();
                } else {
                    // otherwise play music on button click
                    playMusic();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }

    public void pauseMusic() {

        if(mediaPlayer != null) {
            mediaPlayer.pause();
            playButton.setText("Play");
        }
    }

    public void playMusic() {
        if(mediaPlayer != null) {
            mediaPlayer.start();
            playButton.setText("Pause");
        }

    }
}
