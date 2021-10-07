package com.americaalyoum.dmv.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.americaalyoum.dmv.R;
import com.google.firebase.analytics.FirebaseAnalytics;

public class ProductsActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }

    public void buttonCitizenshipApp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.americaalyoum.uscitizenshiptestandpractice2021"));
        startActivity(intent);
    }

    public void buttonNewsApp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.americaalyoum.news"));
        startActivity(intent);
    }

    public void buttonApplicationApp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.conduit.app_5136f729ca4c4aa093f186451c43d1a8.app"));
        startActivity(intent);
    }

    public void buttonAmazon(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.com/MediaVision-America-AlYoum/dp/B0871G4FZL"));
        startActivity(intent);
    }

    public void buttonRokuOne(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://channelstore.roku.com/details/abd0108c49d913326eec60cbf361fa30/americaalyoumtv"));
        startActivity(intent);
    }

    public void buttonRokuTwo(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://channelstore.roku.com/details/ffaacd75ea80ce5f5f1e37c4b0be2610/christian-channels"));
        startActivity(intent);
    }
}