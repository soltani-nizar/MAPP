package com.example.soltani.a222;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class login extends ActionBarActivity {
    String showUrl = "http://192.168.1.124:80/gestion_produit/checkUser.php";
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        final EditText password = (EditText) findViewById(R.id.password);
        final EditText Email = (EditText) findViewById(R.id.Email);
        final Button btn = (Button) findViewById(R.id.btn);
        TextView insc=(TextView)findViewById(R.id.insc);
        insc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getApplicationContext(),inscription.class);
                startActivity(a);
            }
        });
        queue= Volley.newRequestQueue(getApplicationContext());
         btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                StringRequest stringRequest = new StringRequest(Request.Method.POST, showUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                                Log.d("+++", "ok");

                                if(response.indexOf("1")!=-1)
                                { Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
                                    Intent b=new Intent(getApplicationContext(),Accueil.class);
                                    startActivity(b);

                                }else {
                                    Toast.makeText(getApplicationContext(), "okok", Toast.LENGTH_SHORT).show();
                                    }



                            }

                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("+++", "err");
                               // String errorMessage = "Err - data:" + error.getMessage();
                                Toast.makeText(getApplicationContext(), "non conected", Toast.LENGTH_SHORT).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("email",Email.getText().toString());
                        params.put("password",password.getText().toString());

                        return params;
                    }

                };


                queue.add(stringRequest);




            }
        });
    }


}