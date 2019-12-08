package com.example.carlos.derivadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class menu extends AppCompatActivity
{
    @Override
    public void onBackPressed() {

    }

    ImageView salirapp;
  Button deri,tri;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        salirapp = (ImageView) findViewById(R.id.ic_salir);
        salirapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent logoff = new Intent(menu.this,login.class);
                startActivity(logoff);
                finish();
            }
        });

        deri = (Button) findViewById(R.id.derivadas);
        deri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent opcuno = new Intent(menu.this,derivadas.class);
                startActivity(opcuno);
                finish();
            }
        });
        tri = (Button) findViewById(R.id.trigo);
        tri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent opdos = new Intent(menu.this,deritrigo.class);
                startActivity(opdos);
                finish();
            }
        });
        Button definidas=findViewById(R.id.int_def);
        definidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),definidas.class);
                startActivity(intent);
                finish();
            }
        });
        final Button indefnidas=findViewById(R.id.btn_indefinidas);
        indefnidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),indefinidas.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
