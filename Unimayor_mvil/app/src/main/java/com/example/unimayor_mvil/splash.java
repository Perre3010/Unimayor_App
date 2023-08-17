package com.example.unimayor_mvil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(splash.this,Login.class);
                startActivity(intent);
                finish();

                SharedPreferences sharedPreferences = getSharedPreferences("Estado_sesion", MODE_PRIVATE);
                boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

                if (isLoggedIn) {
                    // El usuario ya está autenticado, redirigir al menú
                    Intent intent1 = new Intent(splash.this, Menu.class);
                    startActivity(intent1);
                    finish();
                } else {
                    // El usuario aún no ha iniciado sesión, mostrar la actividad de inicio de sesión
                    Intent intent2 = new Intent(splash.this, Login.class);
                    startActivity(intent2);
                    finish();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(timertask,1000);



    }
}