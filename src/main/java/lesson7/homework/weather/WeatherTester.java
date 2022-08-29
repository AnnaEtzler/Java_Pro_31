package lesson7.homework.weather;

import lesson6.homework.Fact;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public class WeatherTester {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        Call<Weather> call = service.getWeather(33.45, -112.07, "temperature_2m");

        Response<Weather> response = call.execute();

        if(response.isSuccessful())
        {

            Weather weather = response.body();

            System.out.println(weather.getHourly().getTemperature2m());

        }

        System.exit(0);

    }
}
