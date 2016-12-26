package com.example.soltani.a222;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Fragment2 extends Fragment {
String url="http://192.168.1.124:80/gestion_produit/touts_Women_produits_en_panier.php";
    RequestQueue queue;
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        View view2 = inflater.inflate(R.layout.frag2, container, false);
        final ListView lv1=(ListView)view2.findViewById(R.id.lv1);
        final ArrayList<ListProduit> tabprod1=new ArrayList<ListProduit>();
        queue= Volley.newRequestQueue(container.getContext());


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray articles = response.getJSONArray("Women");
                    for (int i = 0; i < articles.length(); i++) {
                        JSONObject article = articles.getJSONObject(i);

                        String libelle = article.getString("libelle");
                        String prix = article.getString("prix");
                        String qte = article.getString("qte");
                        String description = article.getString("description");


                                tabprod1.add(new ListProduit("libelle:"+libelle, "prix:"+prix, "qte:"+qte, "description:"+description));

                        Cadapter2 madabter1=new Cadapter2(tabprod1);


                        lv1.setAdapter(madabter1);

                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(container.getContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());


            }
        });

        // Adding request to request queue



        queue.add(jsonObjectRequest);



        return view2;
    }
}