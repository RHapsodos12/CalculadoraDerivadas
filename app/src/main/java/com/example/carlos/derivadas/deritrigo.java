package com.example.carlos.derivadas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class deritrigo extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    @Override
    public void onBackPressed() {

    }

    int i = 3;
    String[] cosas = {"sen","cos","tan","arc sen","arc cos","arc tan"};
    String elemento;

   EditText res;

   ImageView house, fl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deritrigo);

        Spinner sp = findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);

        ArrayAdapter array = new ArrayAdapter(this,android.R.layout.simple_spinner_item,cosas);
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(array);

        Button btn_enter;
        btn_enter = (Button) findViewById(R.id.cal);
        final TextView result;
        result = (TextView) findViewById(R.id.resultadin);
        final EditText coef,pote;
        coef = (EditText) findViewById(R.id.co);
        pote = (EditText) findViewById(R.id.po);

        res = findViewById(R.id.resIntDef);

        btn_enter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int cofi,poti;
                try
                {
                    cofi = Integer.parseInt(coef.getText().toString());
                    poti = Integer.parseInt(pote.getText().toString());
                    derivadatrigo deri = new derivadatrigo(cofi,elemento,poti);


                    if(res.getText().toString().equals(deri.operacion())) {

                        Toast.makeText(deritrigo.this, "Respuesta Correcta! :D", Toast.LENGTH_LONG).show();
                        result.setText(deri.operacion());

                    } else {

                        if(i > 0) {
                            result.setText("");
                            Toast.makeText(deritrigo.this, "Intenta de nuevo, intentos restantes: "+i, Toast.LENGTH_SHORT).show();
                            i = i-1;

                        } else if(i <= 0) {

                            Toast.makeText(deritrigo.this, "Aqui tienes la respuesta :D", Toast.LENGTH_SHORT).show();
                            result.setText(deri.operacion());
                            res.setEnabled(false);

                            //Muestra Pop up
                            AlertDialog.Builder builder = new AlertDialog.Builder(deritrigo.this);
                            View mView =  getLayoutInflater().inflate(R.layout.trigo, null);
                            builder.setCancelable(false);
                            builder.setView(mView);
                            builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
                            AlertDialog dialog = builder.create();
                            dialog.show();
                            //Fin Pop Up

                            i = 3;
                            res.setEnabled(true);
                        }
                    }

                } catch (Exception e)
                {
                    Toast.makeText(deritrigo.this, "Porfavor ingrese un numero", Toast.LENGTH_SHORT).show();
                }



            }
        });


        house = (ImageView) findViewById(R.id.hoho);
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent vo = new Intent(deritrigo.this,menu.class);
                startActivity(vo);
                finish();
            }
        });

        fl = (ImageView) findViewById(R.id.ouou);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent flec = new Intent(deritrigo.this,login.class);
                startActivity(flec);
                finish();
            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        this.elemento=cosas[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
