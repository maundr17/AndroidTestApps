package com.maundr17.tempconverter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    DecimalFormat round = new DecimalFormat("0.0");

    private EditText enterTemp;
    private Button cButton;
    private Button fButton;
    private TextView convText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterTemp = (EditText) findViewById(R.id.editText);
        cButton   = (Button) findViewById(R.id.celsius_button_id);
        fButton   = (Button) findViewById(R.id.f_button_id);
        convText  = (TextView) findViewById(R.id.show_converted_text);

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = enterTemp.getText().toString();
                double fInput;

                try {
                    fInput = Double.parseDouble(input);
                    double conv = Converter.toCelsius(fInput);
                    String converted = String.valueOf(round.format(conv));
                    convText.setText(converted +" C" );
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Please Enter a Valid Number", Toast.LENGTH_SHORT).show();
                    enterTemp.setText("");
                    convText.setText("");
                }
            }
        });

        fButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = enterTemp.getText().toString();
                double fInput;

                try {
                    fInput = Double.parseDouble(input);
                    double conv = Converter.toFahrenheit(fInput);
                    String converted = String.valueOf(round.format(conv));
                    convText.setText(converted +" F" );
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Please Enter a Valid Number", Toast.LENGTH_SHORT).show();
                    enterTemp.setText("");
                    convText.setText("");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
