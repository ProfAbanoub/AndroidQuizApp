package com.americaalyoum.dmv.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.americaalyoum.dmv.R;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MediaVisionActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_vision);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void mediaVisionEmail(View view) {
        Intent mail = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:info@mediavision.us"));
        startActivity(mail);
    }

    public void mediaVisionWebsite(View view) {
        Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mediavision.us/"));
        startActivity(website);
    }

    public void mediaVisionPhone(View view) {
        Intent phone = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:(714) 888-5959"));
        startActivity(phone);
    }
}