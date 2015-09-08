package com.maundr17.showmethebio;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView bachImage;
    private ImageView mozartImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bachImage   = (ImageView) findViewById(R.id.bachImageView);
        mozartImage = (ImageView) findViewById(R.id.mozartImageView);

        bachImage.setOnClickListener(this);
        mozartImage.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.bachImageView :
                Intent bachIntent = new Intent(MainActivity.this, DetailsActivity.class);
                bachIntent.putExtra("bach", "Hello I am Bach!");
                bachIntent.putExtra("name", "bach");
                startActivity(bachIntent);
                break;

            case R.id.mozartImageView :
                Intent mozartIntent = new Intent(MainActivity.this, DetailsActivity.class);
                mozartIntent.putExtra("mozart", "Hello I am Mozart!");
                mozartIntent.putExtra("name", "mozart");
                startActivity(mozartIntent);
                break;
        }

    }
}
