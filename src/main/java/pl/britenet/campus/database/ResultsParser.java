package pl.britenet.campus.database;

import java.sql.ResultSet;

public interface ResultsParser<T> {

    T parse(ResultSet resultSet);
}
