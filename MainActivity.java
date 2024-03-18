package com.example.sugarfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webView1 = findViewById(R.id.WebView1);
        webView1.loadUrl("file:///android_asset/splash.html");

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent myintent = new Intent(MainActivity.this,LoginEmt.class);
                startActivity(myintent);
            }
        }, 2000);


    }
}