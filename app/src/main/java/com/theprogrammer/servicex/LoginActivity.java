package com.theprogrammer.servicex;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import com.android.volley.RequestQueue;
import com.theprogrammer.servicex.myrequest.MyRequest;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    private Button btn_login;
    private EditText edtEmail, edtPassword;
    private RequestQueue queue;
    private MyRequest request;
    private TextInputLayout til_email,til_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


       til_email = findViewById(R.id.til_email);
       til_password = findViewById(R.id.til_password);
        btn_login = findViewById(R.id.btn_login);

        queue = VolleySingleton.getInstance(this).getRequestQueue();
        request = new MyRequest(this, queue);


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = til_email.getEditText().getText().toString().trim();
                String password = til_password.getEditText().getText().toString().trim();


                if (email.length()>0 && password.length()>0) {



                request.login(email, password, new MyRequest.RegisterCallback() {
                    @Override
                    public void onSuccess(Map<String,String> response) {

                        Intent intent = new Intent(LoginActivity.this,Show_Service.class);

                        intent.putExtra("id",response.get("id"));
                        intent.putExtra("email",response.get("email"));
                        intent.putExtra("nom",response.get("nom"));
                        intent.putExtra("pseudo",response.get("pseudo"));

                        Toast.makeText(LoginActivity.this, "user find", Toast.LENGTH_SHORT).show();
                        Log.d("**********", "hmmmm");
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void inputErrors(Map<String, String> errors) {

                        if (errors.get("email") != null) {
                            til_email.setError(errors.get("email"));

                        }
                        else {

                            til_email.setErrorEnabled(false);
                        }

                        if (errors.get("password") != null) {
                            til_password.setError(errors.get("password"));

                        }
                        else {

                            til_password.setErrorEnabled(false);
                        }
                    }

                    @Override
                    public void onError(String message) {

                        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
                    }


                });
                }

                else {

                    Toast.makeText(getApplicationContext(),"Veuillez remplir les champs",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
