package com.example.enviarinformacion;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static VolleySingleton volleyS = null;
    private RequestQueue requestQueue;
    private VolleySingleton(Context context){requestQueue = Volley.newRequestQueue(context);}
    public static VolleySingleton getInstance(Context context){
        if (volleyS == null){
            volleyS = new VolleySingleton(context);
        }
        return volleyS;
    }
    public RequestQueue getRequestQueue(){return requestQueue;}
}
