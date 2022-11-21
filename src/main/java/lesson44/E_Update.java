package lesson44;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class E_Update {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                // установление соединения с базой данных
                Connection conn = DriverManager.getConnection(url);
                // Statement - запрос - "sql запрос" - sql команда
                Statement stmt = conn.createStatement();
        )
        {

            int rows = stmt.executeUpdate("update salespeople set comm=comm+2;");

            System.out.println(rows);


            System.out.println("Table updated.");
        }
        catch (SQLException e)
        {
            System.err.println("SQLException " + e.getMessage());
        }

    }
}
