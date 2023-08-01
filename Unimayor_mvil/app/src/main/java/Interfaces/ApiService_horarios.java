package Interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface    ApiService_horarios {
    @GET("/estudiante/{codigo}/horarios")
    Call<List<Clases.Horarios>> getMaterias_Horarios(@Path("codigo") int codigo);
}

