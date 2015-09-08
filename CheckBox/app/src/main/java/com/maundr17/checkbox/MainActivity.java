package com.maundr17.checkbox;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private CheckBox catBox;
    private CheckBox dogBox;
    private CheckBox dragonBox;

    private Button showButton;

    private TextView showTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTextView = (TextView) findViewById(R.id.showTextViewId);

        catBox = (CheckBox) findViewById(R.id.catBox);
        dogBox = (CheckBox) findViewById(R.id.dogBox);
        dragonBox = (CheckBox) findViewById(R.id.dragonBox);

        showButton = (Button) findViewById(R.id.showButton);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append(dogBox.getText().toString() + " status is: " + dogBox.isChecked() + "\n");
                stringBuilder.append(catBox.getText().toString() + " status is: " + catBox.isChecked() +"\n");
                stringBuilder.append(dragonBox.getText().toString() + " status is: " + dragonBox.isChecked() +"\n");

                showTextView.setText(stringBuilder);
            }
        });
    }
}
