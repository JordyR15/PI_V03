package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class menu_principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        //txtCorreoUsuario
        TextView correo = (TextView)findViewById(R.id.txtCorreoUsuarioDatos);
        Intent intent = getIntent();
        correo.setText(intent.getStringExtra("id"));
    }
}