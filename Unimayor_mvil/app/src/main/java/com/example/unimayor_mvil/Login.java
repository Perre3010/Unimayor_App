package com.example.unimayor_mvil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText codigo_estudiente;
    private Button ingresar_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializar();
        ingresar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Menu.class);
                startActivity(intent);
                finish();
                capturarDato();

            }
        });
    }

    private void estadoSesion() {
        SharedPreferences sharedPreferences = getSharedPreferences("Estado_sesion", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    private void capturarDato() {
        String codigo_ = codigo_estudiente.getText().toString();
        int codigo_int = Integer.parseInt(codigo_);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MiPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("cod",codigo_int);
        editor.apply();
        estadoSesion();
    }



    private void inicializar() {
        codigo_estudiente = findViewById(R.id.editText_codigo_estudiante);
        ingresar_menu = findViewById(R.id.button_ingresar_menu);
    }

}