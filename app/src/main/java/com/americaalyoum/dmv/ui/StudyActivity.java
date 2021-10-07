package com.americaalyoum.dmv.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

public class StudyActivity extends AppCompatActivity {
    private WebView studyWebView;
    private WebSettings webSettings;
    private TextView loadingTextView;
    private ProgressBar loadingProgressBar;
    private LinearLayout errorLayout;
    private InterstitialAd mInterstitialAd;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
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

        studyWebView = findViewById(R.id.study_webview);
        loadingTextView = findViewById(R.id.study_textview_loading);
        loadingProgressBar = findViewById(R.id.study_progressbar_loading);
        errorLayout = findViewById(R.id.error_layout);

        String URL = "https://www.americaalyoum.com/p/us-driving-test.html";

        studyWebView.loadUrl(URL);
        studyWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                loadingProgressBar.setVisibility(View.VISIBLE);
                loadingTextView.setVisibility(View.VISIBLE);
                studyWebView.setVisibility(View.VISIBLE);
                errorLayout.setVisibility(View.GONE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadingProgressBar.setVisibility(View.GONE);
                loadingTextView.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                errorLayout.setVisibility(View.VISIBLE);
                studyWebView.setVisibility(View.GONE);
                loadingTextView.setVisibility(View.GONE);
                loadingProgressBar.setVisibility(View.GONE);
                Toast.makeText(StudyActivity.this, "Error: No internet connection !", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        webSettings = studyWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setUseWideViewPort(true);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showAd();
            }
        }, 60000);
    }

    @Override
    public void onBackPressed() {
        if (studyWebView.canGoBack()) {
            studyWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd.show(StudyActivity.this);
        }
    }

    public void buttonReload(View view) {
        studyWebView.reload();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mInterstitialAd != null)
            mInterstitialAd = null;
    }
}