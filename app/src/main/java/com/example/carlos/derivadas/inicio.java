package com.example.carlos.derivadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class inicio extends AppCompatActivity
{
  Button acer,entrar ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        acer=(Button) findViewById(R.id.acerca);
        acer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent iniacer = new Intent(inicio.this,acercade.class);
                startActivity(iniacer);
                finish();
            }
        });


        entrar=(Button) findViewById(R.id.enter);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent men = new Intent(inicio.this,menu.class);
                startActivity(men);
                finish();
            }
        });

    }
}
