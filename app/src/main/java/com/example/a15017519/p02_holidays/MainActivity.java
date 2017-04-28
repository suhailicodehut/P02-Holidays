package com.example.a15017519.p02_holidays;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv;
        TextView tvYear;
        ArrayList al;
        ArrayAdapter aa;

        lv = (ListView)findViewById(R.id.lv);

        // adding new data into AL
        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic & Religion");

        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,al);

        lv.setAdapter(aa);
    }
}
