package com.example.sugarfree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class SignInEmt extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
        private Button button2;
        EditText t1,t2,t3;

        private static final String url="http://10.0.2.2/sugarfree/signUp.php";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sign_in_emt);

            button2 = (Button) findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity5();
                    insertdata();

                }
            });

            Spinner spinner = findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.typeofdiabetes, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);

            Spinner spinner2 = findViewById(R.id.spinner2);
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner2.setAdapter(adapter2);
            spinner2.setOnItemSelectedListener(this);




        }

        private void insertdata() {
            t1=(EditText)findViewById(R.id.textInputEditText1);
            t2=(EditText)findViewById(R.id.editTextTextPassword);
            t3=(EditText)findViewById(R.id.textInputEditText);
            Spinner spinner = findViewById(R.id.spinner);
            Spinner spinner2 = findViewById(R.id.spinner2);

            final String username=t1.getText().toString().trim();
            final String password=t2.getText().toString().trim();
            final String age=t3.getText().toString().trim();
            final String Gender=spinner.getSelectedItem().toString().trim();
            final String DiabetesType=spinner2.getSelectedItem().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> param=new HashMap<String,String>();
                    param.put("t1",username);
                    param.put("t2",password);
                    param.put("t3",age);
                    param.put("spinner",Gender);
                    param.put("spinner2",DiabetesType);


                    return param;
                }
            };
            RequestQueue queue= Volley.newRequestQueue(getApplicationContext());

            request.setRetryPolicy(new DefaultRetryPolicy(
                    10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            ));
            queue.add(request);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String text = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
        public void openActivity5(){
            Intent intent = new Intent(this, LoginEmt.class);
            startActivity(intent);
        }

    }