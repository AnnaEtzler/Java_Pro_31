package lesson5.homework;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FactsService {
    @GET("/facts/{random}")
    Call<Fact> getFact(@Path("random") String random);


    @GET("facts/random")
    Call<Fact> getFact();
}
