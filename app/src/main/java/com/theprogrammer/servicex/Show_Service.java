package com.theprogrammer.servicex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.theprogrammer.servicex.outils.Exploiteur_selectionner;
import com.theprogrammer.servicex.outils.Service_outils;

public class Show_Service extends AppCompatActivity implements View.OnClickListener {


    private Service_outils service_outils;
    private TextView title1,title2,title3,title4,s_info1,s_info2,s_info3,s_info4;

    private Button btnAccess1,btnAccess2,btnAccess3,btnAccess4;
    private int id_service;

    private Exploiteur_selectionner E_select;


    Bundle extras;

   Intent go_to_add_service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show__service);

        title1 = findViewById(R.id.card_titre);
        title2 = findViewById(R.id.card_titre2);
        title3 = findViewById(R.id.card_titre3);
        title4 = findViewById(R.id.card_titre4);


        s_info1 = findViewById(R.id.card_nbr);
        s_info2 = findViewById(R.id.card_nbr2);
        s_info3 = findViewById(R.id.card_nbr3);
        s_info4 = findViewById(R.id.card_nbr4);

        btnAccess1 = findViewById(R.id.btnAcces);
        btnAccess2 = findViewById(R.id.btnAcces2);
        btnAccess3 = findViewById(R.id.btnAcces3);
        btnAccess4 = findViewById(R.id.btnAcces4);

        btnAccess1.setOnClickListener(this);
        btnAccess2.setOnClickListener(this);
        btnAccess3.setOnClickListener(this);
        btnAccess4.setOnClickListener(this);



        extras = getIntent().getExtras();


        E_select = new Exploiteur_selectionner(extras.getString("id"),extras.getString("nom"),extras.getString("email"));





    }
        @Override
        public void onClick(View v) {


            switch (v.getId()) {

                        case R.id.btnAcces:

                             id_service =1;
                             set_intent_go(id_service);
                            break;
                        case R.id.btnAcces2:

                             id_service =2;
                            set_intent_go(id_service);
                            break;
                        case R.id.btnAcces3:

                              id_service =3;
                            set_intent_go(id_service);
                            break;
                        case R.id.btnAcces4:

                           id_service =4;
                            set_intent_go(id_service);
                            break;

            }

        }




    private void set_intent_go(int id_service) {

        go_to_add_service = new Intent(Show_Service.this,ServiceActivity.class);

        go_to_add_service.putExtra("id_service",id_service);
        go_to_add_service.putExtra("id_users",E_select.getId_users());
        go_to_add_service.putExtra("email",E_select.getEmail());
        go_to_add_service.putExtra("nom",E_select.getNom());


        startActivities(new Intent[]{go_to_add_service});
    }
}