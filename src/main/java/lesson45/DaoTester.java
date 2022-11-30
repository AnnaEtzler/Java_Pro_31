package lesson45;

import lesson45.homework.CustomerDao;
import lesson45.homework.OrderDao;

import java.sql.SQLException;
import java.util.List;

public class DaoTester {
    public static void main(String[] args) throws SQLException {
        SalesDao salesDao = new SalesDao();
       // Sales max = new Sales(4006, "Maxx", "Warsaw", 12);
    //    salesDao.save(max);

        List<Sales> allSales = salesDao.getAll();
       allSales.stream().forEach(sales -> System.out.println(sales.getName()));

        System.out.println("_______________________");
        CustomerDao customerDao = new CustomerDao();
       Customer kot = new Customer(4099, "Kotik", "Wolfsburg", 100, 4001);
       customerDao.save(kot);

       // customerDao.delete(kot);

        List<Customer> allCustomers = customerDao.getAll();
        allCustomers.stream().forEach(customer -> System.out.println(customer.getName()));

        System.out.println("_______________________");


        OrderDao orderDao = new OrderDao();
      //  Order order = new Order(3999, 124365, "2020-03-24",4003,  4006);
      //  orderDao.save(order);


        List<Order> allOrders = orderDao.getAll();
        allOrders.stream().forEach(o -> System.out.println(o.getAmt()));




    };
}
