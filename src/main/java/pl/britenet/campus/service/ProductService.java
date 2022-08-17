package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.model.Category;
import pl.britenet.campus.model.Product;
import pl.britenet.campus.model.builder.CategoryBuilder;
import pl.britenet.campus.model.builder.ProductBuilder;

import java.sql.SQLException;
import java.util.Optional;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Product> getProduct(int id) {
        String sql = String.format("SELECT p.name AS product_name, price, category_id, c.name AS category_name FROM product p LEFT JOIN category c ON p.category_id = c.id WHERE p.id=%d", id);
        Product product = this.databaseService.performSQL(sql, resultSet -> {
            try {
                if (resultSet.next()) {
                    Category category = new CategoryBuilder()
                            .setId(resultSet.getInt("category_id"))
                            .setName(resultSet.getString("category_name"))
                            .getCategory();

                    return new ProductBuilder()
                            .setId(id)
                            .setName(resultSet.getString("product_name"))
                            .setCategoryId(resultSet.getInt("category_id"))
                            .setCategory(category)
                            .setPrice(resultSet.getDouble("price"))
                            .getProduct();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        return Optional.of(product);
    }
}
