package week15;

import java.util.List;

public interface OrderDAO {

    void create(Order order);

    void delete(int orderNumber);

    List<Order> findAll();

    List<Order> findAllByCustomerNumber(int customerNumber);

    void update(String status, int orderNumber);

}
