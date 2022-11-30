package lesson46;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTester {
    private static final String URL = "jdbc:sqlite:shop.db";

    private static final String insert = "insert into user (first, last, age) values (?, ?, ?);";

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(URL);
            conn.setAutoCommit(false);
            statement= conn.prepareStatement(insert);
            // делаем что-то с таблицами базы данных
            statement.setString(1, "Mira");
            statement.setString(2, "Kakova");
            statement.setInt(3, 21);
            if (true){
                throw new RuntimeException();
            }
            int affectedRows = statement.executeUpdate(); // количество "затронутых" строк в таблице
            statement.setString(1, "Ed");
            statement.setString(2, "Smirnov");
            statement.setInt(3, 27);
            affectedRows = statement.executeUpdate(); // количество "затронутых" строк в таблице

            conn.commit(); // все изменения становятся видны другим соединениям


        } catch (SQLException e) {
            System.out.println(e);

            }
        finally {
            if(statement != null){
                statement.close();
            }
            if (conn != null) {
                conn.rollback(); // отменяем транзакцию которые не закомитили
            }
            conn.close();


        }
    }
}
