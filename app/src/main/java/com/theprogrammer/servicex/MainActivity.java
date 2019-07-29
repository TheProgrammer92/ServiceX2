package com.theprogrammer.servicex;

import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.theprogrammer.servicex.outils.Adapter;
import com.theprogrammer.servicex.outils.service_item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button btn_login;
    Intent intent_goToService;
    Intent intent_goToLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Window w = getWindow();

        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        RecyclerView recyclerView= findViewById(R.id.recycle_view);

        List<service_item> mlist = new ArrayList<>();
        mlist.add(new service_item(R.drawable.fond1,"service",R.drawable.black_gradient ,2200));
        mlist.add(new service_item(R.drawable.fond1,"service",R.drawable.black_gradient ,2200));
        mlist.add(new service_item(R.drawable.fond1,"service",R.drawable.black_gradient ,2200));
       Adapter adapter = new Adapter(this,mlist);

       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
*/
        intent_goToLogin = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent_goToLogin);

    }

}
