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
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import Clases.RetrofitClient;
import Interfaces.ApiService_validacion;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private EditText codigo_estudiente;
    private Button ingresar_menu;
    int codigo_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inicializar();
        ingresar_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(Login.this,Menu.class);
                startActivity(intent);
                finish();
                capturarDato();*/

                String codigo = codigo_estudiente.getText().toString();
                if (!codigo.isEmpty()) {
                    int codigo_int = Integer.parseInt(codigo);

                    ApiService_validacion apiService_validacion = RetrofitClient.getRetrofitInstance().create(ApiService_validacion.class);
                    Call<ResponseBody> call = apiService_validacion.validarCodigo(codigo_int);
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if (response.isSuccessful()) {
                                try {
                                    String responseBody = response.body().string();
                                    JSONObject jsonObject = new JSONObject(responseBody);
                                    boolean codigoExiste = jsonObject.getBoolean("existe");
                                    if (codigoExiste) {
                                        // El código existe en la base de datos
                                        Intent intent = new Intent(Login.this, Menu.class);
                                        startActivity(intent);
                                        finish();
                                        capturarDato();
                                    } else {
                                        // El código no existe en la base de datos
                                        Toast.makeText(Login.this, "El código ingresado no existe", Toast.LENGTH_SHORT).show();
                                        codigo_estudiente.setText("");
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                // Error en la respuesta de la API
                                Toast.makeText(Login.this, "Error en la respuesta de la API", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            // Error en la conexión o en la llamada
                            Toast.makeText(Login.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {
                    // Mostrar mensaje de error, el código está vacío
                    Toast.makeText(Login.this, "Por favor ingresa un código", Toast.LENGTH_SHORT).show();
                }

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