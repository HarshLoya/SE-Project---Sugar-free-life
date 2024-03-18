package com.example.sugarfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConsultationFunc extends AppCompatActivity {

    Button proceed, patho;
    EditText Age, SugarLevel;
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation_func);

        patho=findViewById(R.id.buttonPathology);
        Button proceed =(Button) findViewById(R.id.buttonSugar);
        EditText Age =(EditText) findViewById(R.id.InputAge);
        EditText SugarLevel =(EditText) findViewById(R.id.Input);
        TextView Result = (TextView) findViewById(R.id.textViewResult);



        patho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.google.com/maps/search/Pathologist+lab+near+me");
            }
        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int text = Integer.parseInt(Age.getText().toString());
                int text1 = Integer.parseInt(SugarLevel.getText().toString());


                    if((text>=0 && text<=12)&&(text1>=80 && text1<=180) || (text>=13 && text<=19)&&(text1>=70 && text1<=150)|| (text>=20 && text<=150)&&(text1>=70 && text1<=100)){
                        Result.setText("GOOD!! Your Sugar Level is in Control.");
                        Result.setTextColor(Color.GREEN);
                    }
                    else{
                        Result.setText("Sugar Level is Not in Control!! Please Consult Doctor!!");
                        Result.setTextColor(Color.RED);
                    }


            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri =Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


}