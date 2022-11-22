package lesson44.homework;

import java.sql.*;

public class Homework {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                // установление соединения с базой данных
                Connection conn = DriverManager.getConnection(url);
                // Statement - запрос - "sql запрос" - sql команда
                Statement stmt = conn.createStatement();
        )
        {

           stmt.execute("insert into salespeople values (1005, 'Bob', 'Paris', 20);");
            System.out.println("salespeople inserted.");


            select(stmt);
            System.out.println("____________________");



            stmt.execute("delete from salespeople where snum=1005;");
            System.out.println("salespeople DELETE.");

            select(stmt);
        }
        catch (SQLException e)
        {
            System.err.println("SQLException " + e.getMessage());
        }


    }

    public static void select(Statement stmt){
        try (

                ResultSet rs = stmt.executeQuery("select * from salespeople;");
        ) {
            while (rs.next()) {
                System.out.println(
                        rs.getInt("snum") + "|" +
                                rs.getString("sname") + "|" +
                                rs.getString("city") + "|" +
                                rs.getString("comm") + "|"
                );
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}
