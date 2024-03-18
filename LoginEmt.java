package com.example.sugarfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginEmt extends AppCompatActivity {
    EditText Username, Password;


    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_emt);
    Username = (EditText)findViewById(R.id.textInputEditText);
    Password = (EditText)findViewById(R.id.textInputEditText3);


        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
    public void openActivity3(){
        Intent intent = new Intent(this, SignInEmt.class);
        startActivity(intent);
    }
public void OnLogin(View view) {
        String username =Username.getText().toString();
        String password =Password.getText().toString();
        String type = "login";
        backgroundworker background = new backgroundworker(this);
        background.execute(type, username, password);
}
}