package com.example.carlos.derivadas;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class calcular extends AppCompatActivity
{
    int i = 3;
    @Override
    public void onBackPressed() {

    }

    ImageView ca, fe;
   int coeficiente, potencia;
   int xc, xp;
   EditText coe, pot;
   TextView imprimir;
   EditText resp;
  Button scrR;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular);

        ca = (ImageView) findViewById(R.id.casa);
        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent cas = new Intent(calcular.this,menu.class);
                startActivity(cas);
                finish();
            }
        });

        fe = (ImageView) findViewById(R.id.flecha);

        fe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent fle = new Intent(calcular.this,login.class);
                startActivity(fle);
                finish();
            }
        });


        coe= (EditText) findViewById(R.id.coe);
        pot =(EditText) findViewById(R.id.pot);
        imprimir =(TextView) findViewById(R.id.resultado);

        resp = findViewById(R.id.resDerSim);
        //this.coeficiente=Integer.parseInt(coe.getText().toString());
        //this.potencia=Integer.parseInt(pot.getText().toString());


        scrR = (Button) findViewById(R.id.sresult);

        scrR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               int coeficiente, potencia;
               try
               {
                 coeficiente = Integer.parseInt(coe.getText().toString());
                 potencia = Integer.parseInt(pot.getText().toString());
                 Derivada derivada = new Derivada(coeficiente,potencia);

                 if(resp.getText().toString().equals(derivada.operacion())) {

                     Toast.makeText(calcular.this, "Respuesta Correcta! :D", Toast.LENGTH_SHORT).show();
                     imprimir.setText(derivada.operacion());

                 } else {

                     if(i > 0){

                         imprimir.setText("");
                         Toast.makeText(calcular.this, "Intenta de nuevo, intentos restantes: "+i, Toast.LENGTH_SHORT).show();
                         i = i-1;

                     } else if(i <= 0) {

                         imprimir.setText("");

                         Toast.makeText(calcular.this, "Aqui tienes la respuesta :D", Toast.LENGTH_SHORT).show();
                         imprimir.setText(derivada.operacion());
                         imprimir.setEnabled(false);

                         //Muestra Pop up
                         AlertDialog.Builder builder = new AlertDialog.Builder(calcular.this);
                         View mView =  getLayoutInflater().inflate(R.layout.derivadas, null);
                         builder.setCancelable(false);
                         builder.setView(mView);
                         builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {

                             }
                         });
                         AlertDialog dialog = builder.create();
                         dialog.show();

                         i = 3;
                         imprimir.setEnabled(true);
                     }

                 }



               } catch (Exception e)
               {
                   Toast.makeText(calcular.this, "Porfavor ingrese un numero", Toast.LENGTH_SHORT).show();
               }
            }
        });





    }


       /* public String operacion()
        {
            this.coeficiente=Integer.parseInt(coe.getText().toString());
            this.potencia=Integer.parseInt(pot.getText().toString());
            xc = this.coeficiente*this.potencia;
            xp = this.potencia-1;
            return ""+xc+"x^"+xp;
            }

*/

}
