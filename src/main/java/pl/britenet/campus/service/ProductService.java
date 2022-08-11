package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.model.Product;
import pl.britenet.campus.model.builder.ProductBuilder;

import java.sql.SQLException;
import java.util.Optional;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public Optional<Product> getProduct(int id) {
        String sql = String.format("SELECT * FROM product WHERE id=%d", id);
        Product product = this.databaseService.performSQL(sql, resultSet -> {
            try {
                if (resultSet.next()) {
                    return new ProductBuilder()
                            .setId(id)
                            .setName(resultSet.getString("name"))
                            .setCategoryId(resultSet.getInt("category_id"))
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
