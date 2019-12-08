package com.example.carlos.derivadas;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class teoria extends AppCompatActivity
{
    @Override
    public void onBackPressed() {

    }

    ImageView s,v;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teoria);

        s = (ImageView) findViewById(R.id.log);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent logi = new Intent(teoria.this,login.class);
                startActivity(logi);
                finish();
            }
        });


        v = (ImageView) findViewById(R.id.ho);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent m = new Intent(teoria.this,menu.class);
                startActivity(m);
                finish();
            }
        });
    }
}
