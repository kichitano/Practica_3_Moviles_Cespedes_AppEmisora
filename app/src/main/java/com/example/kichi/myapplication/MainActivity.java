package com.example.kichi.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnPedido;
    CheckBox cb1,cb2,cb3,cb4,cb5,cb6;
    ArrayList<String> menu = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        cb4 = (CheckBox) findViewById(R.id.cb4);
        cb5 = (CheckBox) findViewById(R.id.cb5);
        cb6 = (CheckBox) findViewById(R.id.cb6);

        btnPedido = (Button) findViewById(R.id.BtnPedido);
        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.BtnPedido:
                        menu = new ArrayList();
                        if(cb1.isChecked()){
                            menu.add("Picante");
                            menu.add("14.50");
                        }
                        if(cb2.isChecked()){
                            menu.add("Pollo a la brasa");
                            menu.add("16.00");
                        }
                        if(cb3.isChecked()){
                            menu.add("Seco de res");
                            menu.add("14.00");
                        }
                        if(cb4.isChecked()){
                            menu.add("Adobo arequipeño");
                            menu.add("13.50");
                        }
                        if(cb5.isChecked()){
                            menu.add("Rocoto relleno");
                            menu.add("12.00");
                        }
                        if(cb6.isChecked()){
                            menu.add("Arroz con pollo");
                            menu.add("13.00");
                        }
                }
                Gson gson = new Gson();
                String json = gson.toJson(menu);
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,json);
                sendIntent.setType("text/plain");
                if(null != sendIntent.resolveActivity(getPackageManager())){
                    startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.send_to)));
                }
            }
        });
    }
}
