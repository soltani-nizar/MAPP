package com.example.soltani.a222;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class inscription extends AppCompatActivity {
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        final EditText nom_user=(EditText)findViewById(R.id.nom);
        final EditText Email=(EditText)findViewById(R.id.nom);
        final EditText password=(EditText)findViewById(R.id.nom);
        Button insrt=(Button)findViewById(R.id.btninscrit);
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        final String insertUrl = "http://192.168.1.7:80/gestion_produit/createuser.php";
        insrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), "welcom_in_ecommerce", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> parameters  = new HashMap<String, String>();
                        parameters.put("nom_user",nom_user.getText().toString());
                        parameters.put("Email",Email.getText().toString());
                        parameters.put("password",password.getText().toString());

                        return parameters;
                    }
                };
                requestQueue.add(request);
            }

        });
    }
}
