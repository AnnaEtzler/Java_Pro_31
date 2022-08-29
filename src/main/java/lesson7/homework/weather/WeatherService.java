package lesson7.homework.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//https://api.open-meteo.com/v1/forecast
// ?latitude=52.52&longitude=13.41&hourly=temperature_2m
public interface WeatherService {
    @GET("v1/forecast")
    Call<Weather> getWeather(
            @Query("latitude") double lat,
            @Query("longitude") double lon,
            @Query("hourly") String temp
    );
}
