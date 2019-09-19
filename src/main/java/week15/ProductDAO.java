package week15;

import java.util.List;

public interface ProductDAO {

    void create(Product product);

    void delete(String productName);

    List<Product> FindAll();

    List<Product> FindAllByProductVendor(String productVendor);

    void update(String productCode, String productDescription);


}
