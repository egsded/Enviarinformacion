package com.example.enviarinformacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button btn;
    RecyclerView rcv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv= findViewById(R.id.rcv1);
        edt = findViewById(R.id.edt1);
        btn = findViewById(R.id.btn1);
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsn= new JSONObject();
                try {
                    jsn.put("Nombre", edt.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://nuevo.rnrsiilge-org.mx/nombre", jsn, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, "Nombre "+response.toString(), Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }

                });


                VolleySingleton.getInstance(MainActivity.this).getRequestQueue().add(jsonObjectRequest);
            }
        });
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "http://nuevo.rnrsiilge-org.mx/ListaNombre", null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Type tp = new TypeToken<List<Persona>>() {}.getType();
                        //Log.d("persona", tp.toString());
                        //Log.d("pruebon", response.toString());
                        List<Persona> lp = new Gson().fromJson(response.toString(), tp);
                        //Log.d("valor", lp.toString());
                        rcv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        rcv.setAdapter(new AdaptadorPersona(lp, MainActivity.this));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });
                VolleySingleton.getInstance(getApplicationContext()).getRequestQueue().add(jsonArrayRequest);
            }
        });
    }
}
