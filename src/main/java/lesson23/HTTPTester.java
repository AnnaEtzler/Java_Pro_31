package lesson23;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class HTTPTester {
    public static void main(String[] args) throws IOException {

        //{"docs":"https://www.frankfurter.app/docs"}

        URL url = new URL("https://www.frankfurter.app/docs");
       // URLConnection connection = url.openConnection();
        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

     //   OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = connection.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        bufferedReader.lines().forEach(
                stringBuilder::append
        );
        System.out.println(stringBuilder.toString());
    }


}
