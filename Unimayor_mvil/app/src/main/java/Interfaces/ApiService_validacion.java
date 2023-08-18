package Interfaces;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService_validacion {
    @GET("estudiante/validar/{codigo}")
    Call<ResponseBody> validarCodigo(@Path("codigo") int codigo);
}
