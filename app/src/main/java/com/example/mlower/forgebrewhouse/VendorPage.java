package com.example.mlower.forgebrewhouse;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class VendorPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_vendor_page);
        Objects.requireNonNull (getSupportActionBar ()).setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setLogo (R.mipmap.ic_launcher);
        getSupportActionBar ().setDisplayUseLogoEnabled (true);

        final EditText sunriseBomber = findViewById (R.id.sunriseBomberQuantity);
        final EditText sunriseKeg = findViewById (R.id.sunriseKegQuantity);
        final EditText greatWesternBomber = findViewById (R.id.greatWesternBomberQuantity);
        final EditText greatWesternKeg = findViewById (R.id.greatWesternKegQuantity);
        final EditText coalDustBomber = findViewById (R.id.coalDustBomberQuantity);
        final EditText coalDustKeg = findViewById (R.id.coalDustKegQuantity);
        final TextView sunriseBomberCost = findViewById (R.id.txtSunriseBomberCost);
        final TextView sunriseKegCost = findViewById (R.id.txtSunriseKegCost);
        final TextView greatWesternBomberCost = findViewById (R.id.txtGreatWesternBomberCost);
        final TextView greatWesternKegCost = findViewById (R.id.txtGreatWesternKegCost);
        final TextView coalDustBomberCost = findViewById (R.id.txtCoalDustBomberCost);
        final TextView coalDustKegCost = findViewById (R.id.txtCoalDustKegCost);
        final Button btnHome = findViewById (R.id.btnHomePage);
        final Button btnContactUs = findViewById (R.id.btnContactUs);
        final Button btnOnTap = findViewById (R.id.btnWhatsOnTap);
        final Button btnPurchase = findViewById (R.id.btnPurchase);

        btnOnTap.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent onTap = new Intent (VendorPage.this, MainPageActivity.class);
                startActivity (onTap);
            }
        });

        btnHome.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent home = new Intent (VendorPage.this, HomePage.class);
                startActivity (home);
            }
        });

        btnContactUs.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent (VendorPage.this, ContactUs.class);
                startActivity (contact);
            }
        });

        btnPurchase.setOnClickListener (new View.OnClickListener () {
            final TextView total = findViewById (R.id.txtTotal);

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                if (checkQuantity ()) {

                    if (checkPositive ()) {

                        String bomberPriceSunrise = sunriseBomberCost.getText ().toString ();
                        int sunriseBomberPrice = Integer.parseInt (bomberPriceSunrise);
                        String bomberPriceGreatWestern = greatWesternBomberCost.getText ().toString ();
                        int greatWesternBomberPrice = Integer.parseInt (bomberPriceGreatWestern);
                        String bomberPriceCoalDust = coalDustBomberCost.getText ().toString ();
                        int coalDustBomberPrice = Integer.parseInt (bomberPriceCoalDust);
                        String kegPriceSunrise = sunriseKegCost.getText ().toString ();
                        int sunriseKegPrice = Integer.parseInt (kegPriceSunrise);
                        String kegPriceGreatWestern = greatWesternKegCost.getText ().toString ();
                        int greatWesternKegPrice = Integer.parseInt (kegPriceGreatWestern);
                        String kegPriceCoalDust = coalDustKegCost.getText ().toString ();
                        int coalDustKegPrice = Integer.parseInt (kegPriceCoalDust);

                        String quantitySunriseBomber = sunriseBomber.getText ().toString ();
                        int sunriseBomberQuantity = Integer.parseInt (quantitySunriseBomber);
                        String quantityGreatWesternBomber = greatWesternBomber.getText ().toString ();
                        int greatWesternBomberQuantity = Integer.parseInt (quantityGreatWesternBomber);
                        String quantityCoalDustBomber = coalDustBomber.getText ().toString ();
                        int coalDustBomberQuantity = Integer.parseInt (quantityCoalDustBomber);
                        String quantitySunriseKeg = sunriseKeg.getText ().toString ();
                        int sunriseKegQuantity = Integer.parseInt (quantitySunriseKeg);
                        String quantityGreatWesternKeg = greatWesternKeg.getText ().toString ();
                        int greatWesternKegQuantity = Integer.parseInt (quantityGreatWesternKeg);
                        String quantityCoalDustKeg = coalDustKeg.getText ().toString ();
                        int coalDustKegQuantity = Integer.parseInt (quantityCoalDustKeg);

                        int sunriseBomberTotal = sunriseBomberPrice * sunriseBomberQuantity;
                        int sunriseKegTotal = sunriseKegPrice * sunriseKegQuantity;
                        int greatWesternBomberTotal = greatWesternBomberPrice * greatWesternBomberQuantity;
                        int greatWesternKegTotal = greatWesternKegPrice * greatWesternKegQuantity;
                        int coalDustBomberTotal = coalDustBomberPrice * coalDustBomberQuantity;
                        int coalDustKegTotal = coalDustKegPrice * coalDustKegQuantity;
                        int totalCost = sunriseBomberTotal + sunriseKegTotal + greatWesternBomberTotal + greatWesternKegTotal + coalDustBomberTotal + coalDustKegTotal;

                        total.setText ("Thank you! Your Order Has Been Placed\n" + "Amount Due at Delivery: $" + totalCost);

                    }
                }
            }
        });
    }

    private boolean checkQuantity() {
        final EditText sunriseBomber = findViewById (R.id.sunriseBomberQuantity);
        final EditText sunriseKeg = findViewById (R.id.sunriseKegQuantity);
        final EditText greatWesternBomber = findViewById (R.id.greatWesternBomberQuantity);
        final EditText greatWesternKeg = findViewById (R.id.greatWesternKegQuantity);
        final EditText coalDustBomber = findViewById (R.id.coalDustBomberQuantity);
        final EditText coalDustKeg = findViewById (R.id.coalDustKegQuantity);

        if (sunriseBomber.getText ().toString ().isEmpty ()) {
            sunriseBomber.setError ("Invalid Quantity, Please select 0 for none");
            sunriseBomber.requestFocus ();
            return false;
        }

        if (greatWesternBomber.getText ().toString ().isEmpty ()) {
            greatWesternBomber.setError ("Invalid Quantity, Please select 0 for none");
            greatWesternBomber.requestFocus ();
            return false;
        }

        if (coalDustBomber.getText ().toString ().isEmpty ()) {
            coalDustBomber.setError ("Invalid Quantity, Please select 0 for none");
            coalDustBomber.requestFocus ();
            return false;
        }

        if (sunriseKeg.getText ().toString ().isEmpty ()) {
            sunriseKeg.setError ("Invalid Quantity, Please select 0 for none");
            sunriseKeg.requestFocus ();
            return false;
        }

        if (greatWesternKeg.getText ().toString ().isEmpty ()) {
            greatWesternKeg.setError ("Invalid Quantity, Please select 0 for none");
            greatWesternKeg.requestFocus ();
            return false;
        }

        if (coalDustKeg.getText ().toString ().isEmpty ()) {
            coalDustKeg.setError ("Invalid Quantity, Please select 0 for none");
            coalDustKeg.requestFocus ();
            return false;
        }

        return true;
    }

    private boolean checkPositive() {
        final EditText sunriseBomber = findViewById (R.id.sunriseBomberQuantity);
        final EditText sunriseKeg = findViewById (R.id.sunriseKegQuantity);
        final EditText greatWesternBomber = findViewById (R.id.greatWesternBomberQuantity);
        final EditText greatWesternKeg = findViewById (R.id.greatWesternKegQuantity);
        final EditText coalDustBomber = findViewById (R.id.coalDustBomberQuantity);
        final EditText coalDustKeg = findViewById (R.id.coalDustKegQuantity);

        String quantitySunriseBomber = sunriseBomber.getText ().toString ();
        int sunriseBomberQuantity = Integer.parseInt (quantitySunriseBomber);
        String quantityGreatWesternBomber = greatWesternBomber.getText ().toString ();
        int greatWesternBomberQuantity = Integer.parseInt (quantityGreatWesternBomber);
        String quantityCoalDustBomber = coalDustBomber.getText ().toString ();
        int coalDustBomberQuantity = Integer.parseInt (quantityCoalDustBomber);
        String quantitySunriseKeg = sunriseKeg.getText ().toString ();
        int sunriseKegQuantity = Integer.parseInt (quantitySunriseKeg);
        String quantityGreatWesternKeg = greatWesternKeg.getText ().toString ();
        int greatWesternKegQuantity = Integer.parseInt (quantityGreatWesternKeg);
        String quantityCoalDustKeg = coalDustKeg.getText ().toString ();
        int coalDustKegQuantity = Integer.parseInt (quantityCoalDustKeg);


        if (sunriseBomberQuantity < 0) {
            sunriseBomber.setError ("Quantity must be a Positive Value");
            sunriseBomber.requestFocus ();
            return false;
        }

        if (greatWesternBomberQuantity < 0) {
            greatWesternBomber.setError ("Quantity must be a Positive Value");
            greatWesternBomber.requestFocus ();
            return false;
        }

        if (coalDustBomberQuantity < 0) {
            coalDustBomber.setError ("Quantity must be a Positive Value");
            coalDustBomber.requestFocus ();
            return false;
        }

        if (sunriseKegQuantity < 0) {
            sunriseKeg.setError ("Quantity must be a Positive Value");
            sunriseKeg.requestFocus ();
            return false;
        }

        if (greatWesternKegQuantity < 0) {
            greatWesternKeg.setError ("Quantity must be a Positive Value");
            greatWesternKeg.requestFocus ();
            return false;
        }

        if (coalDustKegQuantity < 0) {
            coalDustKeg.setError ("Quantity must be a Positive Value");
            coalDustKeg.requestFocus ();
            return false;
        }

        return true;
    }
}



