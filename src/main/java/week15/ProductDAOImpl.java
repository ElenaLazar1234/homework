package week15;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    public static void main(String[] args) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        productDAO.FindAll()
                .stream()
                .forEach(System.out::println);
        productDAO.FindAllByProductVendor("Min Lin Diecast")
                .stream()
                .forEach(System.out::println);
        productDAO.create(Product.builder()
                .productCode("10_9678")
                .productName("1969 Harley Davidson Ultimate")
                .productLine("Motorcycles")
                .productScale("1:25")
                .productVendor("Autoart Studio Design")
                .productDescription("Require special care and attention.")
                .quantityInStock(9000)
                .buyPrice(BigDecimal.valueOf(50.52))
                .MSRP(95.70).build());
        productDAO.delete("1999 Indy 500 Monte Carlo SS");
        productDAO.update("S18_2949", "Carousel DieCast Legends");

    }


    @Override
    public void create(Product product) {

        try (Connection connection = getConnection()) {
            String sql = "INSERT into product (productCode,productName,productLine,productScale,productVendor,productDescription,quantityInStock,buyPrice,MSRP) values(? ? ? ? ? ? ? ? ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProductCode());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setString(3, product.getProductLine());
            preparedStatement.setString(4, product.getProductScale());
            preparedStatement.setString(5, product.getProductVendor());
            preparedStatement.setString(6, product.getProductDescription());
            preparedStatement.setInt(7, product.getQuantityInStock());
            preparedStatement.setBigDecimal(8, product.getBuyPrice());
            preparedStatement.setDouble(9, product.getMSRP());
            int numberOfModifiedRows = preparedStatement.executeUpdate();

            if (numberOfModifiedRows == 1) {
                System.out.println("the row was inserted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String productName) {

        try (Connection connection = getConnection()) {
            String sql = "DELETE from product WHERE productName =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productName);
            int numberOfModifiedRows = preparedStatement.executeUpdate();
            if (numberOfModifiedRows == 1) {
                System.out.println("the row was deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> FindAll() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM product";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductCode(resultSet.getString("productCode"));
                product.setProductCode(resultSet.getString("productCode"));
                product.setProductLine(resultSet.getString("productLine"));
                product.setProductScale(resultSet.getString("productScale"));
                product.setProductVendor(resultSet.getString("productVendor"));
                product.setProductDescription(resultSet.getString("productDescription"));
                product.setQuantityInStock(resultSet.getInt("quantityInStock"));
                product.setBuyPrice(resultSet.getBigDecimal("buyPrice"));
                product.setMSRP(resultSet.getDouble("MSRP"));
                products.add(product);
            }
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }


    @Override
    public List<Product> FindAllByProductVendor(String productVendor) {
        List<Product> products = new ArrayList<>();

        Product product = new Product();


        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM product WHERE ProductVendor = ?";
            String sqlInjectabil = "SELECT * FROM product WHERE productVendor =" + productVendor;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            Statement statement = connection.createStatement();
            statement.executeQuery(sqlInjectabil);
            preparedStatement.setInt(1, productVendor);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                product.setProductCode(resultSet.getString("productCode"));
                product.setProductCode(resultSet.getString("productCode"));
                product.setProductLine(resultSet.getString("productLine"));
                product.setProductScale(resultSet.getString("productScale"));
                product.setProductVendor(resultSet.getString("productVendor"));
                product.setProductDescription(resultSet.getString("productDescription"));
                product.setQuantityInStock(resultSet.getInt("quantityInStock"));
                product.setBuyPrice(resultSet.getBigDecimal("buyPrice"));
                product.setMSRP(resultSet.getDouble("MSRP"));
                products.add(product);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }


    @Override
    public void update(String productCode, String productDescription) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE product SET productDescription=? WHERE productCode= ?";
            String sqlInjectabil = "UPDATE product SET productDescription=" + productDescription + " WHERE productCode=" + productCode;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productCode);
            preparedStatement.setString(2, productDescription);
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
                    "password")
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
