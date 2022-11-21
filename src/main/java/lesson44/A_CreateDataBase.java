package lesson44;

import java.sql.*;

public class A_CreateDataBase {
    public static void main(String[] args) {
        // https://www.google.com
        // tel:123
        // jdbc:sqlite:/path/to/store.db
        String url = "jdbc:sqlite:shop.db";
        try(Connection con = DriverManager.getConnection(url);) {
            DatabaseMetaData meta = con.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("DB created");
        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
