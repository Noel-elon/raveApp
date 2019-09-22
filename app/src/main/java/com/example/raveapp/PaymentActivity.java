package com.example.raveapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.flutterwave.raveandroid.RaveConstants;
import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RavePayManager;

import java.util.UUID;

public class PaymentActivity extends AppCompatActivity {

    private ImageView payImage;
    private Button buyBut;

    String email = "noelnwaelugo@gmail.com";
    String fName = "Noel";
    String lName = "Nwaelugo";
    String narration = "Book order";
    String txRef;
    String country = "NG";
    String currency = "NGN";
    int amount = 500;

    final String publicKey = "FLWPUBK-ec8406bbd6ae66be0cccc567dedfa69c-X";
    final String encryptionKey = "4291d1b50956cd391c277106 ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);



        payImage = findViewById(R.id.payImage);
        buyBut = findViewById(R.id.button);


        buyBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                makePayment(amount);

            }
        });
    }


    public void makePayment ( int amount){
        txRef = email + " " + UUID.randomUUID().toString();

        /*
        Create instance of RavePayManager
         */
        new RavePayManager(this).setAmount(amount)
                .setCountry(country)
                .setCurrency(currency)
                .setEmail(email)
                .setfName(fName)
                .setlName(lName)
                .setNarration(narration)
                .setPublicKey(publicKey)
                .setEncryptionKey(encryptionKey)
                .setTxRef(txRef)
                .acceptAccountPayments(true)
                .acceptCardPayments(
                        true)
                .acceptMpesaPayments(false)
                .acceptGHMobileMoneyPayments(false)
                .onStagingEnv(false).
                allowSaveCardFeature(true)
                .withTheme(R.style.DefaultTheme)
                .initialize();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
            String message = data.getStringExtra("response");
            if (resultCode == RavePayActivity.RESULT_SUCCESS) {
                Toast.makeText(this, "SUCCESS " + message, Toast.LENGTH_SHORT).show();
            } else if (resultCode == RavePayActivity.RESULT_ERROR) {
                Toast.makeText(this, "ERROR " + message, Toast.LENGTH_SHORT).show();
            } else if (resultCode == RavePayActivity.RESULT_CANCELLED) {
                Toast.makeText(this, "CANCELLED " + message, Toast.LENGTH_SHORT).show();
            }
        }
    }



}
