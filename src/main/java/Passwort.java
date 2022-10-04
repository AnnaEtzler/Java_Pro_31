import java.io.*;

public class Passwort {
    public static void main(String[] args) {
       String file = "C:\\Users\\Anna Z\\IdeaProjects\\Java_Pro_31\\src\\main\\java\\10-million-password-list-top-1000000.txt";
        try (FileReader fr = new FileReader(file)){
            while (fr.ready()){
                int i = fr.read();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
