package com.theprogrammer.servicex.myrequest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.theprogrammer.servicex.outils.Demande_info;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SaveServiceRequest {

    Context context;
    RequestQueue queue;
    public SaveServiceRequest(Context context, RequestQueue queue) {

        this.context = context;
        this.queue = queue;
    }


    public void save_service(final Demande_info demande_info, final RegisterCallback callback)
     {
        String url = "http://192.168.56.1/ServiceX/save_service.php";


        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {


            @Override
            public void onResponse(String response) {

                Map<String, String> errors = new HashMap<>();


                Toast.makeText(context, response, Toast.LENGTH_LONG).show();
                Log.d("**********", response);

                try {
                    JSONObject json = new JSONObject(response);

                    Boolean error = json.getBoolean("error");
                    if (!error) {

                        //'linscription s'est bien terminé

                        callback.onSuccess("La connexion, s'est bien deroulée");
                    }
                    else {

                        JSONObject  messages = json.getJSONObject("message");
                        String message = json.getString("message");

                            errors.put("message",message);

                        callback.inputErrors(errors);


                    }
                }

                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                if (error instanceof NetworkError) {

                    callback.onError("Impossible de se connecter");
                }
                else if(error instanceof  VolleyError) {

                    callback.onError("une Erreur s'est produite");
                }

                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("*************", String.valueOf(error));
            }
        }) {
            @Override
            protected Map<String, String > getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<>();

                map.put("service_selected",demande_info.getSpinner_select());
                map.put("montant",demande_info.getMontant());
                map.put("id_service",demande_info.getId_service());
                map.put("id_users",demande_info.getId_users());


                return map;

            }
        };





        queue.add(request);
    }

    public interface RegisterCallback{

        void onSuccess(String message);
        void inputErrors(Map<String ,String> errors);
        void onError(String message);
    }}
