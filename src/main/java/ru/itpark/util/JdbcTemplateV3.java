package ru.itpark.util;

import ru.itpark.domain.House;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JdbcTemplateV3 {
    private JdbcTemplateV3() {
    }

    // <T> -> House:
    // public static List<House> executeQuery(String url, String sql, RowMapperV2<House> mapper) throws SQLException {
    public static <T> List<T> executeQuery(String url, String sql, RowMapperV2<T> mapper) throws SQLException {
        try (
                // только переменные, на которых нужно вызвать .close() -> AutoCloseable
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            List<T> result = new LinkedList<>();
            while (resultSet.next()) { // переходит на следующую позицию и возвращает true, если там есть данные
                result.add(mapper.map(resultSet));
            }
            return result;
        }
    }
}
