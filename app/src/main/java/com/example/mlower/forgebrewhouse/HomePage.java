package com.example.mlower.forgebrewhouse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_home_page);
        Objects.requireNonNull (getSupportActionBar ()).setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setLogo (R.mipmap.ic_launcher);
        getSupportActionBar ().setDisplayUseLogoEnabled (true);

        final Button btnOnTap = findViewById (R.id.btnOnTap);
        final Button btnContactUs = findViewById (R.id.btnContactUs);
        final Button btnVendors = findViewById (R.id.btnVendors);

        btnOnTap.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent onTap = new Intent (HomePage.this, MainPageActivity.class);
                startActivity (onTap);
            }
        });

        btnContactUs.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent contactUs = new Intent(HomePage.this, ContactUs.class);
                startActivity (contactUs);
            }
        });

        btnVendors.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent vendor = new Intent (HomePage.this, VendorPage.class);
                startActivity (vendor);
            }
        });

    }
}
