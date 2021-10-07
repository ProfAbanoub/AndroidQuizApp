package com.americaalyoum.dmv.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.americaalyoum.dmv.R;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AboutActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void iconYoutube(View view) {
        Intent youtube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCBB9V3amwMDddKF7KhA-6Iw"));
        startActivity(youtube);
    }

    public void iconTwitter(View view) {
        Intent twitter = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.twitter.com/americaalyoumtv"));
        startActivity(twitter);
    }

    public void iconInstagram(View view) {
        Intent instagram = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/americaalyoumtv"));
        startActivity(instagram);
    }

    public void iconFacebook(View view) {
        Intent facebook = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/americaalyoum"));
        startActivity(facebook);
    }
}