package com.example.carlos.derivadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class acercade extends AppCompatActivity
{ Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acercade);

        volver = (Button) findViewById(R.id.backini);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent volver = new Intent(acercade.this,inicio.class);
                startActivity(volver);
                finish();
            }
        });
    }
}
