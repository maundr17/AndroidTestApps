package com.maundr17.showmethebio;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class DetailsActivity extends Activity {

    private ImageView profileImage;
    private TextView bioText;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);

        profileImage = (ImageView) findViewById(R.id.profileImageId);
        bioText = (TextView) findViewById(R.id.profileTextId);



        extras = getIntent().getExtras();

        if(extras != null) {
            String name = extras.getString("name");

            showDetails(name);
        }
    }

    public void showDetails(String mName) {

        if(mName.equals("bach")) {
            profileImage.setImageDrawable(getResources().getDrawable(R.drawable.bach_profile));
            bioText.setText(extras.getString(mName));

        } else if(mName.equals("mozart")) {
            profileImage.setImageDrawable(getResources().getDrawable(R.drawable.mozart_profile));
            bioText.setText(extras.getString(mName));
        }
    }


}
