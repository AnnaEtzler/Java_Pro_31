package Lesson25;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class HttpTester {
    public static void main(String[] args)  {
        String webService = "https://api.frankfurter.app/latest?amount=10";
        try {
            System.out.println(httpGetString(webService));
        } catch (Exception e) {
            System.err.println("exeption: " + e.getMessage());
        }

    }

    public static String httpGetString(String webService) throws IOException {
        URL url = new URL(webService);
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = connection.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            bufferedReader.lines().forEach(stringBuilder::append);

        }


        return stringBuilder.toString();
    }
}
