package com.example.unimayor_mvil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity implements View.OnClickListener {

    ImageView horario;
    ImageView eventos;
    ImageView noticias;
    ImageView notas;
    ImageView directorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        referenciar();
        listener();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void listener() {
        horario.setOnClickListener(this);
        eventos.setOnClickListener(this);
        noticias.setOnClickListener(this);
        notas.setOnClickListener(this);
        directorio.setOnClickListener(this);
    }

    private void referenciar() {
        horario = findViewById(R.id.imageView_horario);
        eventos = findViewById(R.id.imageView_eventos);
        noticias = findViewById(R.id.imageView_noticias);
        notas = findViewById(R.id.imageView_notas);
        directorio = findViewById(R.id.imageView_directorio);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView_horario:
                Intent intent = new Intent(this,Horarios.class);
                startActivity(intent);
                break;

            case R.id.imageView_eventos:
                Intent intent2 = new Intent(this,Eventos.class);
                startActivity(intent2);
                break;

            case R.id.imageView_noticias:
                Intent intent3 = new Intent(this,Noticias.class);
                startActivity(intent3);
                break;

            case R.id.imageView_notas:
                Intent intent4 = new Intent(this,Notas.class);
                startActivity(intent4);
                break;

            case R.id.imageView_directorio:
                Intent intent5 = new Intent(this,Directorio.class);
                startActivity(intent5);
                break;
        }
    }
}