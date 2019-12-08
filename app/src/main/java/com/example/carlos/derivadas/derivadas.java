package com.example.carlos.derivadas;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class derivadas extends AppCompatActivity
{
  ImageView salir, home, teo, cal;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derivadas);

        salir = (ImageView) findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent fuera = new Intent(derivadas.this,login.class);
                startActivity(fuera);
                finish();
            }
        });

         home = (ImageView) findViewById(R.id.inicio);
         home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent home = new Intent(derivadas.this,menu.class);
                startActivity(home);
                finish();
            }
        });

         teo = (ImageView) findViewById(R.id.teoria);
         teo.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                 Intent t = new Intent(derivadas.this,teoria.class);
                 startActivity(t);
                 finish();
             }
         });

         cal = (ImageView) findViewById(R.id.calcular);
         cal.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                 Intent c = new Intent(derivadas.this,calcular.class);
                 startActivity(c);
                 finish();
             }
         });
    }
}
