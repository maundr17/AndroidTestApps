package com.maundr17.myactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends Activity {

    private TextView myTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        myTextView = (TextView) findViewById(R.id.textView);
        backButton = (Button) findViewById(R.id.back_button);

        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            String myString = extras.getString("firstActivity");

            myTextView.setText(myString);
        }



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData", "This is from the second Activity");
                returnIntent.putExtra("something else", "This is something else");
                setResult(RESULT_OK, returnIntent);
                finish();


            }
        });

    }


}
