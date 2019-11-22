package ru.itpark;


import ru.itpark.domain.House;
import ru.itpark.service.HouseService;
import ru.itpark.util.JdbcTemplateV3;

import java.sql.*;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
//        List<House> houses = JdbcTemplateV3.<House>executeQuery(
//                "jdbc:sqlite:D:/domofond/src/main/resources\\db.sqlite",
//                "SELECT id, name, district, price, underground, rooms, square FROM houses",
//                resultSet -> new House(resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getString("district"),
//                        resultSet.getInt("price"),
//                        resultSet.getString("underground"),
//                        resultSet.getInt("rooms"),
//                        resultSet.getInt("square")
//                )
//        );
//
HouseService service = new HouseService();
//        System.out.println(houses);
//        это работает- закомментировала для удобства вывода, yj cltkfkf gjnjv xthtp cthdbc
//        houses.removeIf(o -> o.getId() == 3);
//        System.out.println(houses);
        System.out.println(service.searchByName("flat"));
        System.out.println(service.searchByName("ondo"));
        System.out.println(service.searchByPrice(7_000, 165_000));
        System.out.println(service.getSortedByPriceAsc());
        System.out.println(service.getSortedBy((o1, o2) -> -(o1.getPrice() - o2.getPrice())));
        System.out.println(service.getSortedBy((o1, o2) -> o1.getName().compareTo(o2.getName())));
        System.out.println(service.searchByDistrict("TOwn"));
        System.out.println(service.removeById(3));

    }
}


