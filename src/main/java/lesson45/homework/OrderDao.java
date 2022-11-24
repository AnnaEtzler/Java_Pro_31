package lesson45.homework;

import lesson45.Order;
import lesson45.Sales;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private Connection conn;
    private static final String insert = "insert into orders values (?, ?, ?, ?, ?);";
    private final PreparedStatement insertStatement;
    private final Statement selectStatement;
    private static final String URL = "jdbc:sqlite:shop.db";

    public OrderDao() throws SQLException {
        Connection conn = DriverManager.getConnection(URL);
        insertStatement = conn.prepareStatement(insert);
        selectStatement = conn.createStatement();
    }

    public Order save(Order order) throws SQLException {
        insertStatement.setInt(1, order.getId());
        insertStatement.setInt(2, order.getAmt());
        insertStatement.setInt(3, order.getCnum());
        insertStatement.setString(4, order.getOdate());
        insertStatement.setInt(5, order.getSnum());
        insertStatement.executeUpdate();

        return order;
    }

    public void delete(Sales sales){

    }

    public List<Order> getAll() throws SQLException {
        List<Order> result = new ArrayList<>();
        try (
                ResultSet rs = selectStatement.executeQuery("select * from orders;");
        )
        {
            while (rs.next())
            {
                result.add(
                        new Order(
                                rs.getInt("onum"),
                                rs.getInt("amt"),

                                rs.getString("odate"),
                                rs.getInt("cnum"),
                                rs.getInt("snum")
                        )
                );
            }
        }
        return result;
    }

    public List<Order> getAllCity(String city){
        return null;
    }


}
