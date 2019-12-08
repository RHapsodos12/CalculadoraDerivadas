package com.example.carlos.derivadas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener
{

    RequestQueue rq;
    JsonRequest jrq;
    EditText user,pwd;
    Button access;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {  //EN ESTA LLAVE SE ABREN LAS REFERENCIAS

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        rq=Volley.newRequestQueue(getApplicationContext());

        user = (EditText) findViewById(R.id.usuario);
        pwd  = (EditText) findViewById(R.id.contra);
        access = (Button) findViewById(R.id.btn_acceso);
        access.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //inicio_sesion();

                Intent instancia=new Intent(login.this,inicio.class);
                startActivity(instancia);
                finish();
            }
        });

    } //EN ESTA LLAVE SE CIERRAN LAS REFERENCIAS

    void inicio_sesion()
    {
        String url="http://www.martinezb.proyectosutd.com/Examen/sesion.php?user="+user.getText().toString()+"&pwd="+pwd.getText().toString();

        jrq=new JsonObjectRequest(Request.Method.GET,url,null, this,this );
        rq.add(jrq);
    }

    @Override
    public void onErrorResponse(VolleyError error)
    {
        Toast.makeText(getApplicationContext(),"Datos incorrectos/Verifique su conexión",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response)
    {

       /* User usuarios=new User();
        Toast.makeText(getApplicationContext(),"Acceso correcto a: "+user.getText().toString(),Toast.LENGTH_LONG).show();

        //Utilizar los objetos y arreglos de tipo jason para traer a android los valores del webservice
        JSONArray jsonArray=response.optJSONArray("datos");
        JSONObject jsonObject=null;

        try
        {
            jsonObject=jsonArray.getJSONObject(0);
            usuarios.setUser(jsonObject.optString("user"));
            usuarios.setPwd(jsonObject.optString("pwd"));
            usuarios.setNames(jsonObject.optString("names"));
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        Intent instancia=new Intent(login.this,inicio.class);
        startActivity(instancia);
        finish();
        */
    }
}
