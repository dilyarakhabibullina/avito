package ru.itpark.util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JdbcTemplateV3 {
    private JdbcTemplateV3() {
    }

    public static <T> List<T> executeQuery(String url, String sql, RowMapperV2<T> mapper) throws SQLException {
        try (

                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            List<T> result = new LinkedList<>();
            while (resultSet.next()) {
                result.add(mapper.map(resultSet));
            }
            return result;
        }
    }
}
