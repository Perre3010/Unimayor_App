package Interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService_notas {
    @GET("/estudiante/{codigo}/notas")
    Call<List<Clases.Notas>> getNotas(@Path("codigo") int codigo);
}
