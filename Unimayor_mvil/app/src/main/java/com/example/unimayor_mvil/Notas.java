package com.example.unimayor_mvil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import Adaptadores.Notas_Adaptador;
import Clases.RetrofitClient;
import Interfaces.ApiService_notas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Notas extends AppCompatActivity {
    private RecyclerView recyclerView;
    Notas_Adaptador adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        referenciar();
        inputData();
    }

    private void inputData() {
        inputAdapter();
        int codigo = 1;
        ApiService_notas apiService_notas = RetrofitClient.getRetrofitInstance().create(ApiService_notas.class);
        Call<List<Clases.Notas>> call = apiService_notas.getNotas(codigo);
        call.enqueue(new Callback<List<Clases.Notas>>() {
            @Override
            public void onResponse(Call<List<Clases.Notas>> call, Response<List<Clases.Notas>> response) {
                if(response.isSuccessful()){
                    List<Clases.Notas> list = response.body();
                    if(list!=null){
                        adaptador.setData(list);
                    }else{
                        Toast.makeText(Notas.this, "No hay registros", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Notas.this, "Error al obtener datos. Verifica tu conexión a Internet 111.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Clases.Notas>> call, Throwable t) {
                Toast.makeText(Notas.this, "Error al obtener datos. Verifica tu conexión a Internet 222.", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void inputAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
        adaptador = new Notas_Adaptador();
        recyclerView.setAdapter(adaptador);
    }

    private void referenciar() {
        recyclerView = findViewById(R.id.recyclerView_notas);
    }
}