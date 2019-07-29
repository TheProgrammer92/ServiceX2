package com.theprogrammer.servicex.myrequest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.theprogrammer.servicex.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MyRequest {

    private Context context;
    private RequestQueue queue;



    public MyRequest(Context context, RequestQueue queue) {
        this.context = context;
        this.queue = queue;
    }


    public void login (final String email, final String password, final RegisterCallback callback)
        {
            String url = "http://192.168.56.1/ServiceX/login.php";


            StringRequest  request = new StringRequest(Request.Method.POST, url, new Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Map<String, String> errors = new HashMap<>();
                    Map<String, String> map_response = new HashMap<>();

                    try {
                        JSONObject json = new JSONObject(response);

                        Boolean error = json.getBoolean("error");
                        if (!error) {

                            //'linscription s'est bien terminé

                            JSONObject  messages = json.getJSONObject("messages");
                            if (messages.has("id")) {

                                Toast.makeText(context, messages.getString("id"), Toast.LENGTH_SHORT).show();
                                Log.d("**********", "find users");
                                map_response.put("id",messages.getString("id"));

                            }
                            if (messages.has("nom")) {
                                Toast.makeText(context, messages.getString("nom"), Toast.LENGTH_SHORT).show();
                                Log.d("**********", "find users");
                                map_response.put("nom",messages.getString("nom"));

                            }

                            if (messages.has("pseudo")) {

                                map_response.put("pseudo",messages.getString("pseudo"));

                            }

                            map_response.put("email",email);

                            callback.onSuccess(map_response);
                        }

                        else {

                            JSONObject  messages = json.getJSONObject("messages");
                            if (messages.has("id")) {

                                errors.put("email",messages.getString("email"));

                            }
                            if (messages.has("password")) {

                                errors.put("password",messages.getString("password"));

                            }

                            callback.inputErrors(errors);


                        }
                    } catch (JSONException e) {
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

                    map.put("email",email);
                    map.put("password",password);

                    return map;

                }
            };


                queue.add(request);
        }

        public interface RegisterCallback{

                     void onSuccess(Map<String,String> response);
                     void inputErrors(Map<String ,String> errors);
                     void onError(String message);
        }
    }




