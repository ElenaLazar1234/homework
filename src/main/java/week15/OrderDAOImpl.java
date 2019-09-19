package week15;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.Calendar.MARCH;


public class OrderDAOImpl implements OrderDAO {
    public static void main(String[] args) {
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        orderDAO.findAll()
                .stream()
                .forEach(System.out::println);

        orderDAO.findAllByCustomerNumber(10419)
                .stream()
                .forEach(System.out::println);

        orderDAO.create(Order.builder()
                .orderDate(LocalDate.of(2005, 05, 14))
                .requiredDate(LocalDate.of(2005, 06, 14))
                .shippedDate(LocalDate.of(2005, 05, 28))
                .comments("")
                .status("In progress")
                .customerNumber(11000).
                        build());
        orderDAO.delete(10419);
        orderDAO.update("Shipped", 10429);

    }


    @Override
    public void create(Order order) {
        LocalDate date = LocalDate.of(2010, MARCH, 14);

        try (Connection connection = getConnection()) {
            String sql = " INSERT INTO order(orderDate,requiredDate,shippedDate,status,comments,customerNumber) VALUES (? ? ? ? ? ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, Date.valueOf(order.getOrderDate()));
            preparedStatement.setDate(2, Date.valueOf(order.getRequiredDate()));
            preparedStatement.setDate(3, Date.valueOf(order.getShippedDate()));
            preparedStatement.setString(4, order.getComments());
            preparedStatement.setString(5, order.getStatus());
            preparedStatement.setInt(6, order.getCustomerNumber());
            int numberOfModifiedRows = preparedStatement.executeUpdate();

            if (numberOfModifiedRows == 1) {
                System.out.println("the row was inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int orderNumber) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE * from order WHERE id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);

            int numberOfModifiedRows = preparedStatement.executeUpdate();
            if (numberOfModifiedRows == 1) {
                System.out.println("the row was deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM order";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderNumber(resultSet.getInt("orderNumber"));
                order.setOrderDate(resultSet.getDate("orderDate").toLocalDate());
                order.setRequiredDate(resultSet.getDate("requiredDate").toLocalDate());
                order.setShippedDate(resultSet.getDate("shippedDate").toLocalDate());
                order.setStatus(resultSet.getString("status"));
                order.setComments(resultSet.getString("comments"));
                order.setCustomerNumber(resultSet.getInt("customerNumber"));
                orders.add(order);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    @Override
    public List<Order> findAllByCustomerNumber(int customerNumber) {
        List<Order> orders = new ArrayList<>();

        Order order = new Order();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM order WHERE customerNumber = ?";
            String sqlInjectabil = "SELECT * FROM orders WHERE customerNumber =" + customerNumber;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Statement statement = connection.createStatement();
            statement.executeQuery(sqlInjectabil);
            preparedStatement.setInt(1, customerNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                order.setOrderNumber(resultSet.getInt("orderNumber"));
                order.setOrderDate(resultSet.getDate("orderDate").toLocalDate());
                order.setRequiredDate(resultSet.getDate("requiredDate").toLocalDate());
                order.setShippedDate(resultSet.getDate("shippedDate").toLocalDate());
                order.setStatus(resultSet.getString("status"));
                order.setComments(resultSet.getString("comments"));
                order.setCustomerNumber(resultSet.getInt("customerNumber"));
                orders.add(order);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    @Override
    public void update(String status, int orderNumber) {

        try (Connection connection = getConnection()) {
            String sql = "UPDATE order SET status=? WHERE orderNumber= ?";
            String sqlInjectabil = "UPDATE orders SET status=" + status + " WHERE orderNumber=" + orderNumber;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, orderNumber);
            preparedStatement.setString(2, status);
            int numberOfModifiedRows = preparedStatement.executeUpdate();
            if (numberOfModifiedRows == 1) {
                System.out.println("update successfully");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels?useSSL=true&serverTimezone=EET",
                    "siit",
                    "password");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
