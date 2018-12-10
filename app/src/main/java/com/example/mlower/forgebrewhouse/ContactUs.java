package com.example.mlower.forgebrewhouse;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_contact_us);
        Objects.requireNonNull (getSupportActionBar ()).setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setLogo (R.mipmap.ic_launcher);
        getSupportActionBar ().setDisplayUseLogoEnabled (true);

        final Button btnSend = findViewById (R.id.btnEmailUs);
        final Button btnHome = findViewById (R.id.btnHomePage);
        final Button btnOnTap = findViewById (R.id.btnOnTap);
        final Button btnVendors = findViewById (R.id.btnVendors);

        btnOnTap.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent onTap = new Intent (ContactUs.this, MainPageActivity.class);
                startActivity (onTap);
            }
        });

        btnHome.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent contactUs = new Intent(ContactUs.this, HomePage.class);
                startActivity (contactUs);
            }
        });

        btnVendors.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent vendor = new Intent (ContactUs.this, VendorPage.class);
                startActivity (vendor);
            }
        });

        btnSend.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent emailUs = new Intent(ContactUs.this,EmailUs.class);
                startActivity (emailUs);
            }
        });


    }
}
