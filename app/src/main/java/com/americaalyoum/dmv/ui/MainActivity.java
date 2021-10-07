package com.americaalyoum.dmv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.americaalyoum.dmv.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, "ca-app-pub-3074260317927726/6893767441", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });
    }

    public void btnTakeExam(View view) {
        Intent testActivityIntent = new Intent(this, StartingScreenActivity.class);
        startActivity(testActivityIntent);
        showAd();
    }

    public void btnStudy(View view) {
        Intent studyActivityIntent = new Intent(this, StudyActivity.class);
        startActivity(studyActivityIntent);
        showAd();
    }

    public void btnContact(View view) {
        Intent contactActivityIntent = new Intent(this, ContactActivity.class);
        startActivity(contactActivityIntent);
    }

    public void btnAbout(View view) {
        Intent aboutActivityIntent = new Intent(this, AboutActivity.class);
        startActivity(aboutActivityIntent);
    }

    public void btnMediaVision(View view) {
        Intent mediaVisionActivityIntent = new Intent(this, MediaVisionActivity.class);
        startActivity(mediaVisionActivityIntent);
    }

    public void btnProducts(View view) {
        Intent productsIntent = new Intent(this, ProductsActivity.class);
        startActivity(productsIntent);
    }

    public void showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(MainActivity.this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mInterstitialAd != null)
            mInterstitialAd = null;
    }

}