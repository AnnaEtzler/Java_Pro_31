package lesson44;

import java.sql.*;

public class B_CreateTables {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:shop.db";
        try(Connection con = DriverManager.getConnection(url);
        Statement statement = con.createStatement())    // Statment SQL запрос
        {

            statement.execute("create table if not exists salespeople (snum int primary key not null, sname text not null, city text not null, comm integer not null)");

            statement.execute("create table if not exists customers (cnum int primary key not null, cname text not null, city text not null, rating integer not null, snum int not null);");

            statement.execute("create table if not exists orders (onum int primary key not null, amt int not null, odate text not null, cnum int not null, snum int not null);");
            System.out.println("Tables created.");

        } catch (SQLException e) {
            System.err.println("SQLException " + e.getMessage());
        }
    }
}
