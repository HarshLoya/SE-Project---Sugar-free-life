package com.example.sugarfree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class HealthTipFunc extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tip_func);

        webView = findViewById(R.id.WebView3);
        webView.loadUrl("file:///android_asset/HealthTipsFunc.html");
    }
}