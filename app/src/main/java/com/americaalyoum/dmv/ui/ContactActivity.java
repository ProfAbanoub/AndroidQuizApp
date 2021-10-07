package com.americaalyoum.dmv.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.americaalyoum.dmv.R;
import com.google.firebase.analytics.FirebaseAnalytics;

public class ContactActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void sendMail(View view) {
        Intent sendMail = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:info@AmericaAlyoum.com"));
        startActivity(sendMail);
    }

    public void phoneCall(View view) {
        Intent phoneCall = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+1 424-777-3444"));
        startActivity(phoneCall);
    }
}