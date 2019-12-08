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

import org.w3c.dom.Text;

public class definidas extends AppCompatActivity
{
    int i = 3;
    @Override
    public void onBackPressed() {

    }

   ImageView casin,flechin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_definidas);
        final EditText a,b,funcion;
        a=findViewById(R.id.et_a);
        b=findViewById(R.id.et_b);
        funcion=findViewById(R.id.et_funcion);
        final TextView resultado=findViewById(R.id.tv_resultado);
        Button btn_enter=findViewById(R.id.btn_calcular);

        final EditText resp = findViewById(R.id.resIntDef);

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   String a_,b_,function;
                   a_=a.getText().toString();
                   b_=b.getText().toString();
                   function=funcion.getText().toString();

                   integral integral=new integral();


                   //System.out.println(resp.getText().toString());

                if(resp.getText().toString().equals(String.valueOf(integral.calculateIntegral(a_,b_,"1",function)))) {

                    Toast.makeText(definidas.this, "Respuesta Correcta! :D", Toast.LENGTH_SHORT).show();
                    resultado.setText(String.valueOf(integral.calculateIntegral(a_,b_,"1",function)));

                } else {
                    //System.out.println("Else "+i);
                    if(i > 0) {
                        resultado.setText("");
                        Toast.makeText(definidas.this, "Intenta de nuevo, intentos restantes: "+i, Toast.LENGTH_SHORT).show();
                        i = i-1;

                    } else if(i <= 0) {

                        Toast.makeText(definidas.this, "Aqui tienes la respuesta :D", Toast.LENGTH_SHORT).show();
                        resultado.setText(String.valueOf(integral.calculateIntegral(a_,b_,"1",function)));
                        resp.setEnabled(false);

                        //Muestra Pop up
                        AlertDialog.Builder builder = new AlertDialog.Builder(definidas.this);
                        View mView =  getLayoutInflater().inflate(R.layout.definidas, null);
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
                        resp.setEnabled(true);
                    }
                }

                }
                catch (Exception e)
                {
                    //Toast.makeText(definidas.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }
            }
        });

        casin = (ImageView) findViewById(R.id.casita);
        casin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent casilla = new Intent(definidas.this,menu.class);
                startActivity(casilla);
                finish();
            }
        });

        flechin = (ImageView) findViewById(R.id.flechita);
        flechin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent flechilla = new Intent(definidas.this,login.class);
                startActivity(flechilla);
                finish();
            }
        });

    }
}
