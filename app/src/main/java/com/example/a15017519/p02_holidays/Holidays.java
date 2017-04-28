package com.example.a15017519.p02_holidays;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Holidays extends AppCompatActivity {


    ListView lv;
    TextView tvHolidayType;
    ArrayAdapter aa;
    ArrayList<HolidayDetails> holidayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_holidays);

        lv = (ListView) this.findViewById(R.id.ListViewHoliday);
        tvHolidayType = (TextView) findViewById(R.id.textViewType);
        holidayList = new ArrayList<HolidayDetails>();

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tvHolidayType.setText(type);

        aa = new CustomAdapter(this, R.layout.row, holidayList);
        if(type.equalsIgnoreCase("secular")) {
            holidayList.add(new HolidayDetails("New Year's Day", "1 Jan 2017", R.drawable.celeb));
            holidayList.add(new HolidayDetails("Labour Day", "1 May 2017", R.drawable.labor));
        }else{
            holidayList.add(new HolidayDetails("Chinese New Year", "28-29 Jan 2017", R.drawable.cny));
            holidayList.add(new HolidayDetails("Good Friday", "14 April 2017", R.drawable.good));
        }

        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HolidayDetails selected = holidayList.get(position);

                Toast.makeText(Holidays.this, selected.getName()
                                + " Date: " + selected.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });


    }

}
