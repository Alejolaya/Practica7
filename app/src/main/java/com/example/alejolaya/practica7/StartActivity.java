package com.example.alejolaya.practica7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.FacebookSdk;

public class StartActivity extends AppCompatActivity {

    TextView nombreprint;
    Button logiout;
    MainActivity ejemplo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_start);
        nombreprint=(TextView)findViewById(R.id.namelogin);

        String nombre=getIntent().getStringExtra("nombrecompleto");
        nombreprint.setText(nombre);
        logiout=(Button)findViewById(R.id.login);


    }

    public void loginsql(View view){
        //se borra los usuarios almacenados
        SharedPreferences settings =getSharedPreferences("mipreferencia", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString("email", "");
        editor.putString("pass", "");
        // configura el almacenamiento
        editor.commit();
        Intent intent = new Intent(StartActivity.this,MainActivity.class);
        startActivity(intent);
        finish();

    }


}