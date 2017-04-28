package com.example.a15017519.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv;
        TextView tvYear;
        final ArrayList al;
        ArrayAdapter aa;

        lv = (ListView)findViewById(R.id.lv);

        // adding new data into AL
        al = new ArrayList<String>();
        al.add("Secular");
        al.add("Ethnic & Religion");

        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,al);

        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = al.get(position).toString();

                Intent i = new Intent(MainActivity.this,
                        Holidays.class);
                i.putExtra("type",selectedType);
                startActivity(i);

            }
        });

    }
}
