package com.example.sugarfree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class InfoFunc extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_func);


        webView = findViewById(R.id.WebView);
        webView.loadUrl("file:///android_asset/InfoFunc.html");
    }
}