package com.theprogrammer.servicex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.theprogrammer.servicex.myrequest.SaveServiceRequest;
import com.theprogrammer.servicex.outils.Demande_info;
import com.theprogrammer.servicex.outils.Exploiteur_selectionner;
import com.theprogrammer.servicex.outils.Service_outils;

import java.util.Map;

public class ServiceActivity extends AppCompatActivity {

    private Spinner mySpinner;
    private EditText edtMontant;
    private Button btn_save_service;
    private String spinner_select;
    private String service_montant;

    private RequestQueue queue;

    private  int id_service;
    private Demande_info demande_info;
    private Exploiteur_selectionner E_select;


    private SaveServiceRequest saveServiceRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        queue = VolleySingleton.getInstance(this).getRequestQueue();
        saveServiceRequest = new SaveServiceRequest(this,queue);
      mySpinner = findViewById(R.id.spinner_client);
      btn_save_service = findViewById(R.id.save_service);
        edtMontant = findViewById(R.id.edt_montant);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ServiceActivity.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names_client));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner.setAdapter(myAdapter);


        btn_save_service.setOnClickListener(save_onClickListener);

        //recuperation du service

        E_select= new Exploiteur_selectionner();
        id_service = getIntent().getExtras().getInt("id_service");
        E_select.setId_users( getIntent().getExtras().getString("id_users"));


    }

    View.OnClickListener save_onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           spinner_select = String.valueOf(mySpinner.getSelectedItem());
            service_montant = String.valueOf(edtMontant.getText());


          String id = E_select.getId_users();
            demande_info = new Demande_info(String.valueOf(id_service),id,service_montant,spinner_select);

            String msg ="spinner   " + spinner_select + service_montant + " " + demande_info.getId_service();




            saveServiceRequest.save_service(demande_info, new  SaveServiceRequest.RegisterCallback() {

                @Override
                public void onSuccess(String message) {
                    Toast.makeText(ServiceActivity.this, "success!!", Toast.LENGTH_LONG).show();
                    Log.d("**********", "Le service a ete inseré");
                }

                @Override
                public void inputErrors(Map<String, String> errors) {

                    Toast.makeText(ServiceActivity.this, errors.get("message"), Toast.LENGTH_SHORT).show();
                    Log.d("**********", "hmm tout  mauvais");
                }

                @Override
                public void onError(String message) {
                    Toast.makeText(ServiceActivity.this, message, Toast.LENGTH_SHORT).show();
                    Log.d("**********", "hmm tout mauvais");
                }
            });

        }
    };
}
