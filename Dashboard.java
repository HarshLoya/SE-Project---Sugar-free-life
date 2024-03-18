package com.example.sugarfree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    private ImageButton button4;
    private ImageButton button5;
    private ImageButton button6;
    private ImageButton button7;
    private ImageButton button8;

    private ImageButton button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        button4 = (ImageButton) findViewById(R.id.imageButton1);
        button5 = (ImageButton) findViewById(R.id.imageButton2);
        button6 = (ImageButton) findViewById(R.id.imageButton3);
        button7 = (ImageButton) findViewById(R.id.imageButton4);
        button8 = (ImageButton) findViewById(R.id.imageButton5);

        button10 = (ImageButton) findViewById(R.id.imageButton6);


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {openActivity5();

            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {openActivity10();

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v3) {
                openActivity6();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v4) {
                openActivity7();
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v5) {
                openActivity8();
            }
        });


        setUpToolbar();
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.nav_home:

                        Intent intent = new Intent(Dashboard.this, MainActivity.class);
                        startActivity(intent);
                        break;

//Paste your privacy policy link

//                    case  R.id.nav_Policy:{
//
//                        Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse(""));
//                        startActivity(browserIntent);
//
//                    }
                    //       break;
                    case  R.id.nav_share:{

                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody =  "http://play.google.com/store/apps/detail?id=" + getPackageName();
                        String shareSub = "Try now";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));

                    }
                    break;
                }
                return false;
            }
        });
    }
    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }



    private void openActivity5() {
        Intent intent = new Intent(this, DietFunc.class);
        startActivity(intent);

    }

    public void openActivity4(){
        Intent intent = new Intent(this, InfoFunc.class);
        startActivity(intent);
    }
    public void openActivity6(){
        Intent intent = new Intent(this, HealthTipFunc.class);
        startActivity(intent);
    }
    public void openActivity7(){
        Intent intent = new Intent(this, ExerciseFunc.class);
        startActivity(intent);
    }
    public void openActivity8(){
        Intent intent = new Intent(this, ConsultationFunc.class);
        startActivity(intent);
    }

    public void openActivity10(){
        Intent intent = new Intent(this, ReminderFunc.class);
        startActivity(intent);
    }
}