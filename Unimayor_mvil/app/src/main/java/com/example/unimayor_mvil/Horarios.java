package com.example.unimayor_mvil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Adaptadores.Horarios_Adapter;
import Clases.RetrofitClient;
import Interfaces.ApiService_horarios;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Horarios extends AppCompatActivity {
    private RecyclerView recyclerView;
    Horarios_Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios);
        referenciar();
        inputData();
    }

    private void inputData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        adapter = new Horarios_Adapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        SharedPreferences sharedPreferences = getSharedPreferences("MiPref", MODE_PRIVATE);
        int savedValue = sharedPreferences.getInt("cod", 0);

        ApiService_horarios apiService_horarios = RetrofitClient.getRetrofitInstance().create(ApiService_horarios.class);
        Call<List<Clases.Horarios>> call = apiService_horarios.getMaterias_Horarios(savedValue);
        call.enqueue(new Callback<List<Clases.Horarios>>() {
            @Override
            public void onResponse(Call<List<Clases.Horarios>> call, Response<List<Clases.Horarios>> response) {
                if (response.isSuccessful()) {
                    List<Clases.Horarios> materiasHorarios = response.body();
                    if (materiasHorarios != null) {
                        adapter.setData(materiasHorarios);
                    } else {
                        Toast.makeText(Horarios.this, "No hay registros", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Error al obtener datos. Verifica tu conexión a Internet 111.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Clases.Horarios>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error al obtener datos. Verifica tu conexión a Internet 222.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void referenciar() {
        recyclerView = findViewById(R.id.recyclerView_horarios);
    }
}
