package com.example.carlos.derivadas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class indefinidas extends AppCompatActivity
{

    int i = 3;

 ImageView salir_app,volver_menu;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indefinidas);
        final EditText coeficiente=findViewById(R.id.et_coeficiente);
        final EditText potencia=findViewById(R.id.et_potencia);
        final TextView resultado=findViewById(R.id.tv_resultado);

        final EditText respuesta = findViewById(R.id.resIntInd);

        final Button calcular=findViewById(R.id.btn_calculo);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int coeficiente_,potencia_;
                try
                {
                    coeficiente_=Integer.valueOf(coeficiente.getText().toString());
                    potencia_=Integer.valueOf(potencia.getText().toString());

                    DerivadaIndefinida indefinida=new DerivadaIndefinida(coeficiente_,potencia_);

                    if(respuesta.getText().toString().equals(String.valueOf(indefinida.operarIntegral()))) {

                        Toast.makeText(indefinidas.this, "Respuesta Correcta! :D", Toast.LENGTH_LONG).show();
                        resultado.setText(String.valueOf(indefinida.operarIntegral()));

                    } else {
                        //System.out.println("Else "+i);
                        if(i > 0) {
                            resultado.setText("");
                            Toast.makeText(indefinidas.this, "Intenta de nuevo, intentos restantes: "+i, Toast.LENGTH_SHORT).show();
                            i = i-1;

                        } else if(i <= 0) {

                            Toast.makeText(indefinidas.this, "Aqui tienes la respuesta :D", Toast.LENGTH_SHORT).show();
                            resultado.setText(String.valueOf(indefinida.operarIntegral()));
                            respuesta.setEnabled(false);

                            //Muestra Pop up
                            AlertDialog.Builder builder = new AlertDialog.Builder(indefinidas.this);
                            View mView =  getLayoutInflater().inflate(R.layout.indefinidas, null);
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
                            respuesta.setEnabled(true);
                        }
                    }
                    //System.out.println(respuesta.getText().toString());
                }
                catch (Exception e)
                {
                    Toast.makeText(indefinidas.this, "Inserta un número válido", Toast.LENGTH_SHORT).show();
                }
            }
        });


       volver_menu = (ImageView) findViewById(R.id.casasa);
       volver_menu.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               Intent regresar_m = new Intent(indefinidas.this,menu.class);
               startActivity(regresar_m);
               finish();
           }
       });

       salir_app = (ImageView) findViewById(R.id.flechacha);
       salir_app.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v)
           {
               Intent salirapppli = new Intent(indefinidas.this,login.class);
               startActivity(salirapppli);
               finish();
           }
       });
    }
}
