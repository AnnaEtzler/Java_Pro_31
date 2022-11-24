package lesson44.homework;

import java.sql.*;

public class Homework {
    public static void main(String[] args) {
        Integer snum = 1039;
        String sname = "Bob";
        String citytext = "Paris";
        Integer comm = 20;
        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                // установление соединения с базой данных
                Connection conn = DriverManager.getConnection(url);
                // Statement - запрос - "sql запрос" - sql команда
                PreparedStatement stmt = conn.prepareStatement("insert into salespeople values (?, ?, ?, ?);")
        )
        {

           stmt.setInt(1, snum);
           stmt.setString(2, sname);
           stmt.setString(3, citytext);
           stmt.setInt(4, comm);
           stmt.execute();
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
