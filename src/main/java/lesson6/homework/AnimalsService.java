package lesson6.homework;

// https://cat-fact.herokuapp.com
// /facts/random
// ?animal_type=cat&amount=2

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface AnimalsService {

    // facts/random?animal_type=dog&amount=2 // @Query ? и & добавляются автоматически
    @GET("facts/random")
    Call<List<Fact>> getFacts(
            @Query("animal_type") String animal,
            @Query("amount") int number
    );
}