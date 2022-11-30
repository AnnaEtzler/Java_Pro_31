package lesson46;

import java.sql.*;
import java.util.stream.Collectors;

public class UserTester {
    private static final String URL = "jdbc:sqlite:shop.db";
    private static final String [] columns = { "id" }; // колонка которая autoincrement
    private static final String insert = "insert into user (first, last, age) values (?, ?, ?);";


    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement insertStatement = conn.prepareStatement(insert, columns)){

            insertStatement.setString(1, "Dina");
            insertStatement.setString(2, "Petrowa");
            insertStatement.setInt(3, 31);

            int affectedRows = insertStatement.executeUpdate();
            System.out.println("rows affected: " + affectedRows);

            if (affectedRows > 0){
                try (ResultSet rs = insertStatement.getGeneratedKeys()){
                    if(rs.next()){
                        long id = rs.getLong(1);
                        System.out.println("id=" + id);
                    }

                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
