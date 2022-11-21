package lesson44;

import java.sql.*;

public class D_Query {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db"; // shop.db - название файла
        try (
                // установление соединения с базой данных
                Connection conn = DriverManager.getConnection(url);
                // Statement - запрос - "sql запрос" - sql команда
                Statement stmt = conn.createStatement();
                // ResultSet - окошко в содержимое результата запроса
                ResultSet rs = stmt.executeQuery("select * from salespeople;");
                PreparedStatement preparedStatement = conn.prepareStatement("select * from salespeople where comm > ?");

        )
        {
            // stmt.execute("insert into ...");
            while (rs.next())
            {
                int snum = rs.getInt("snum");
                String sname = rs.getString("sname");
                String city = rs.getString("city");
                int comm = rs.getInt("comm");

                System.out.printf("%10d|%10s|%10s|%10d\n", snum, sname, city, comm);
            }
            preparedStatement.setInt(1, 14); // первый позиционный параметр
            System.out.println("-------");

            ResultSet rs1 = preparedStatement.executeQuery();
            while (rs1.next())
            {
                int snum = rs1.getInt("snum");
                String sname = rs1.getString("sname");
                String city = rs1.getString("city");
                int comm = rs1.getInt("comm");
                System.out.printf("%10d|%10s|%10s|%10d\n", snum, sname, city, comm);
            }




        }
        catch (SQLException e)
        {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
