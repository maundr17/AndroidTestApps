package com.maundr17.mycustomlistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity{

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] bookTitles = new String[]{
                "The Alchemist",
                "The Giver",
                "How to Kill a Mockingbird",
                "Lost in Paradise",
                "The Complete Android and Java Developer...",
                "Titanic",
                "The Kite Runner",
                "Lord of the Rings",
                "The Hobbit",
                "Java in a Nutshell",
                "The Social Network",
                "Game Programming All in One"

        };

        final String[] bookPages = new String[]{
                "300 pages",
                "350 pages",
                "900 pages",
                "230 pages",
                "1200 pages",
                "450 pages",
                "350 pages",
                "120 pages",
                "2300 pages",
                "2100 pages",
                "329 pages",
                "1978 pages"

        };

        final String[] authors = new String[]{

                "Paulo Coelho",
                "Lois Lowry",
                "Harper Lee",
                "Somell Author!",
                "Paulo and Fahd",
                "Simon Adams",
                "Khaled Hosseini",
                "J. R. R. Tolkien",
                "J. R. R. Tolkien",
                "Flannagan",
                "Ben Mezrich",
                "Harbour"

        };

        ArrayList<HashMap<String, String>> authorList = new ArrayList<>();

        for(int i = 0; i<10; i++) {
            HashMap<String, String> data = new HashMap<>();
            data.put("title", bookTitles[i]);
            data.put("pages", bookPages[i]);
            data.put("author", authors[i]);

            authorList.add(data);
        }

        listView = (ListView) findViewById(R.id.list);

        // setup adapter
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), authorList);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int mPosition = position;
                String itemClickedId = listView.getItemAtPosition(mPosition).toString();

                Toast.makeText(getApplicationContext(), "Id Clicked: "+ itemClickedId, Toast.LENGTH_LONG ).show();
            }
        });

    }

}
