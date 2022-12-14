package lesson45;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class SalesDao {
    private Connection conn;
    private static final String insert = "insert into salespeople values (?, ?, ?, ?);";
    private final PreparedStatement insertStatement;
    private final Statement selectStatement;
    private static final String URL = "jdbc:sqlite:shop.db";

    public SalesDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        insertStatement = conn.prepareStatement(insert);
        selectStatement = conn.createStatement();
    }

    public Sales save(Sales sales) throws SQLException {
        insertStatement.setInt(1, sales.getId());
        insertStatement.setString(2, sales.getName());
        insertStatement.setString(3, sales.getCity());
        insertStatement.setInt(4, sales.getCommission());
        insertStatement.executeUpdate();

        return sales;
    }

    public void delete(Sales sales){

    }

    public List<Sales> getAll() throws SQLException {
        List<Sales> result = new ArrayList<>();
        try (
                ResultSet rs = selectStatement.executeQuery("select * from salespeople;");
        )
        {
            while (rs.next())
            {
                result.add(
                        new Sales(
                                rs.getInt("snum"),
                                rs.getString("sname"),
                                rs.getString("city"),
                                rs.getInt("comm")
                        )
                );
            }
        }
        return result;
    }

    public List<Sales> getAllCity(String city){
        return null;
    }
}
