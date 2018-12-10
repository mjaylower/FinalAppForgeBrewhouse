package com.example.mlower.forgebrewhouse;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class EmailUs extends AppCompatActivity {

    private EditText emailSubject;
    private EditText emailMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_email_us);
        Objects.requireNonNull (getSupportActionBar ()).setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setLogo (R.mipmap.ic_launcher);
        getSupportActionBar ().setDisplayUseLogoEnabled (true);


        final Button sendEmail = findViewById (R.id.btnSendEmail);

        sendEmail.setOnClickListener (new View.OnClickListener (){
            @Override
            public void onClick(View v){
                sendMail();
            }
        });

    }
    private void sendMail(){
        Log.i("Send email", "");
        final EditText emailSubject = findViewById (R.id.txtSubjectLine);
        final EditText emailMessage = findViewById (R.id.txtEmailBody);
        final EditText emailRecipient = findViewById (R.id.txtRecipient);

        String subject = emailSubject.getText().toString ();
        String body = emailMessage.getText().toString();
        String[] recipient = {emailRecipient.getText ().toString ()};

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData (Uri.parse ("mailto:")).setType ("text/plain");


        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        try {
            startActivity(Intent.createChooser(intent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(EmailUs.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }


    }
}
