package com.example.mlower.forgebrewhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainPageActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView bomberList;
    ListView tapList;
    String[] bomber;
    String[] tap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main_page);
        Objects.requireNonNull (getSupportActionBar ()).setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setLogo (R.mipmap.ic_launcher);
        getSupportActionBar ().setDisplayUseLogoEnabled (true);

        final Button btnHome = findViewById (R.id.btnHomePage);
        final Button btnContactUs = findViewById (R.id.btnContactUs);
        final Button btnVendors = findViewById (R.id.btnVendors);

        bomberList = findViewById (R.id.bomberToGoList);
        tapList = findViewById (R.id.tapList);

        bomber = getResources ().getStringArray (R.array.bomberList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, bomber);

        tap = getResources ().getStringArray (R.array.tapList);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, tap);
        bomberList.setAdapter (arrayAdapter);
        bomberList.setOnItemClickListener (this);
        tapList.setAdapter (arrayAdapter2);
        tapList.setOnItemClickListener (this);

        btnHome.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent onTap = new Intent (MainPageActivity.this, HomePage.class);
                startActivity (onTap);
            }
        });

        btnContactUs.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent contactUs = new Intent (MainPageActivity.this, ContactUs.class);
                startActivity (contactUs);
            }
        });

        btnVendors.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent vendor = new Intent (MainPageActivity.this, VendorPage.class);
                startActivity (vendor);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view;
        Toast.makeText (this, "You clicked on" + tv.getText (), Toast.LENGTH_SHORT).show ();


    }
}
