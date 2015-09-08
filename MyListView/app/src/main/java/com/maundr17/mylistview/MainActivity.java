package com.maundr17.mylistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        final String values[] = {
                "The Complete Android Web Developers Course",
                "Hello,World!",
                "ListViews are great!",
                "My name is Ryan",
                "I am 25",
                "Hello,World!",
                "ListViews are great!",
                "My name is Ryan",
                "I am 25",
                "Hello,World!",
                "ListViews are great!",
                "My name is Ryan",
                "I am 25",
                "Hello,World!",
                "ListViews are great!",
                "My name is Ryan",
                "I am 25",
                "Hello,World!",
                "ListViews are great!",
                "My name is Ryan",
                "I am 25",
                "Hello,World!",
                "ListViews are great!",
                "My name is Ryan",
                "I am 25"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,android.R.id.text1, values);

        // assign adapter to listView
        listView.setAdapter(adapter);

        //set Onclick
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int intPosition = position;
                String clickedValue = listView.getItemAtPosition(intPosition).toString();

                Toast.makeText(getApplicationContext(), clickedValue,Toast.LENGTH_LONG).show();
            }
        });
    }


}
