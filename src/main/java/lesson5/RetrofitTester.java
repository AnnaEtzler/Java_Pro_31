package lesson5;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class RetrofitTester {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.country.is/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        GeoCoderService service = retrofit.create(GeoCoderService.class);

        Call <GeoCode> call = service.getGeoCode("8.8.4.4");
        Response<GeoCode> response = call.execute();  // синхронный запрос
        // call.enqueue(); асинхронный запрос
        if(response.isSuccessful()){ // если результат запроса удачный
            GeoCode geoCode = response.body();
            System.out.println("Country: " + geoCode.getCountry() + ", ip: " + geoCode.getIp());
        }
        System.exit(0);
    }
}
