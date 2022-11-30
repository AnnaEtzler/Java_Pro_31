package lesson45.homework;

import lesson45.Customer;
import lesson45.Sales;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {



    private Connection conn;
    private static final String insert = "insert into customers values (?, ?, ?, ?, ?);";
    private final PreparedStatement insertStatement;
    private PreparedStatement selectStatement ;
    private PreparedStatement deleteStatment;
    private static final String URL = "jdbc:sqlite:shop.db";

    public CustomerDao() throws SQLException {

        conn = DriverManager.getConnection(URL);
        insertStatement = conn.prepareStatement(insert);
        selectStatement = conn.prepareStatement("select * from customers;");
        deleteStatment = conn.prepareStatement("DELETE FROM customers where cnum = ? ;");
    }

    public void delete(Customer customer) throws SQLException {
        deleteStatment.setInt(1, customer.getId());
        deleteStatment.executeUpdate();


    }

    public void save(Customer customer) throws SQLException {
        insertStatement.setInt(1, customer.getId());
        insertStatement.setString(2, customer.getName());
        insertStatement.setString(3, customer.getCity());
        insertStatement.setInt(4, customer.getRating());
        insertStatement.setInt(5, customer.getSnum());
        insertStatement.executeUpdate();



      //  return customer;
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> result = new ArrayList<>();

        try (
                ResultSet rs = selectStatement.executeQuery()
        )
        {
            while (rs.next())
            {
                result.add(
                        new Customer(
                                rs.getInt("cnum"),
                                rs.getString("cname"),
                                rs.getString("city"),
                                rs.getInt("rating"),
                                rs.getInt("snum")
                        )
                );
            }
        }
        return result;
    }
}
