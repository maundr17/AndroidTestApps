package com.maundr17.myradiobuttons;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioChoiceButton;

    private TextView showChoiceTextView;
    private Button showButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup TextView
        showChoiceTextView = (TextView) findViewById(R.id.showTextView);

        // setup RadioGroup
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);

        // setup Button
        showButton = (Button) findViewById(R.id.showChoiceButton);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOption = radioGroup.getCheckedRadioButtonId();
                radioChoiceButton = (RadioButton) findViewById(selectedOption);

                showChoiceTextView.setText(radioChoiceButton.getText());
            }
        });
    }


}
