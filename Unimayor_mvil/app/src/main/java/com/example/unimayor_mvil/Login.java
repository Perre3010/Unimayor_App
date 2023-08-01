package com.example.unimayor_mvil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText codigo_estudiente;
    private Button ingresar_menu;
    private static Context appContext;

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
            }
        });
    }

    private void inicializar() {
        codigo_estudiente = findViewById(R.id.editText_codigo_estudiante);
        ingresar_menu = findViewById(R.id.button_ingresar_menu);
    }

    public static Context getAppContext() {
        return appContext;
    }
}