package ru.itpark;

import ru.itpark.service.HouseService;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        HouseService service = new HouseService();

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


