package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.model.raport.CategoryAVGRaport;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaportService {

    private final DatabaseService databaseService;

    public RaportService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<CategoryAVGRaport> getCategoryAVGRaport() {
        String sql = "SELECT c.name \"name\", IF(AVG(p.price) IS NULL, 0, AVG(p.price)) \"avg\" FROM `product` p RIGHT JOIN category c ON p.category_id = c.id GROUP BY c.name";
        return this.databaseService.performSQL(sql, resultSet -> {
            List<CategoryAVGRaport> raports = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    raports.add(new CategoryAVGRaport(
                            resultSet.getString("name"),
                            resultSet.getDouble("avg"))
                    );
                }
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            return raports;
        });
    }

}
