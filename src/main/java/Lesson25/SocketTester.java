package Lesson25;

import java.io.*;
import java.net.Socket;

public class SocketTester {
    public static void main(String[] args) {
        //colormind.io/list/
        //foo();


        String serverName = "colormind.io";
        int port = 80;
        String webService = "/list/";
        try (
                Socket socket = new Socket(serverName, port);  // tcp  соединение
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        ) {

            outputStreamWriter.write("GET http://" + serverName + webService + " HTTP/1.0\n\n");
            outputStream.flush();
            bufferedReader.lines().forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("exeption: " + e.getMessage());
        }
    }




    public static void foo() {
        String serverName = "colormind.io";
        int port = 80;
        String webService = "/list/";
        try (
                Socket socket = new Socket(serverName, port); // tcp
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        ) {
            outputStreamWriter.write("GET http://" + serverName + webService + " HTTP/1.0\n\n");
            outputStreamWriter.flush();
            bufferedReader.lines().forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("exception: " + e.getMessage());
        }
    }
}
