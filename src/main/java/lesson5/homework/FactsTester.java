package lesson5.homework;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class FactsTester {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cat-fact.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        System.out.println("1 Retrofit");
        FactsService service = retrofit.create(FactsService.class);
        System.out.println("2 FactsService");
        Call<Fact> call = service.getFact("random");
        System.out.println("3 Call<Fact>");

        Response<Fact> response = call.execute();  // синхронный запрос
        System.out.println("4  Response<Fact>");
        // call.enqueue(); асинхронный запрос
        if (response.isSuccessful()) { // если результат запроса удачный
            System.out.println("5 response.isSuccessful()");
            Fact f = response.body();
            if((f != null ? f.getText() : null) != null){
                System.out.println("6. f.getText() not null");
                System.out.println("факт про кошку: " + f.getText());
                System.exit(0);
            } else {
                System.out.println("что-то не то");
                System.exit(1);
            }



        }
    }
}
