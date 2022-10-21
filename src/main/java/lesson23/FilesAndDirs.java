package lesson23;

import java.io.File;
import java.util.Arrays;

public class FilesAndDirs {
    public static void main(String[] args) {
        String homeDir = System.getProperty("user.home");
        System.out.println(homeDir);


        String separator = System.getProperty("file.separator");
        File home = new File(homeDir);
        String path = home.getAbsolutePath();
        boolean ifFile = home.isFile();
        System.out.println("path " + path);
        System.out.println("isFile " + ifFile);

        Arrays.stream(home.list())
                .forEach(
                f -> {
                    File newFile = new File(path + separator + f);
                    long size = newFile.length();
                    String type = newFile.isFile() ? "f" : "d";
                    System.out.println(newFile.getAbsolutePath() + " " + type + " " + size);
                }
                );
    }
}
