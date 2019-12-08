package ru.itpark.service;

import ru.itpark.domain.House;
import ru.itpark.util.JdbcTemplateV3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class HouseService {
    List<House> houses = JdbcTemplateV3.<House>executeQuery(
            "jdbc:sqlite:D:/domofond/src/main/resources\\db.sqlite",
            "SELECT id, name, district, price, underground, rooms, square FROM houses",
            resultSet -> new House(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("district"),
                    resultSet.getInt("price"),
                    resultSet.getString("underground"),
                    resultSet.getInt("rooms"),
                    resultSet.getInt("square")
            )
    );

    public List<House> getHouses () throws SQLException {
        List<House> houses = JdbcTemplateV3.<House>executeQuery(
                "jdbc:sqlite:D:/domofond/src/main/resources\\db.sqlite",
                "SELECT id, name, district, price, underground, rooms, square FROM houses",
                resultSet -> new House(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("district"),
                        resultSet.getInt("price"),
                        resultSet.getString("underground"),
                        resultSet.getInt("rooms"),
                        resultSet.getInt("square")
                )
        );
        return houses;
    }



    public HouseService() throws SQLException {
    }

    public List<House> searchByName(String text) throws SQLException {
//        List<House> houses = JdbcTemplateV3.<House>executeQuery(
//////                "jdbc:sqlite:D:/domofond/src/main/resources\\db.sqlite",
//////                "SELECT id, name, district, price, underground, rooms, square FROM houses",
//////                resultSet -> new House(resultSet.getInt("id"),
//////                        resultSet.getString("name"),
//////                        resultSet.getString("district"),
//////                        resultSet.getInt("price"),
//////                        resultSet.getString("underground"),
//////                        resultSet.getInt("rooms"),
//////                        resultSet.getInt("square")
//////                )
//////        );


        getHouses();


        List<House> houseList = new ArrayList<>();
        for (House requiredProduct : houses) {
        if (requiredProduct.getName().contains(text)) {
            houseList.add(requiredProduct);

        }
        houseList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }
        return houseList;
}

    public List<House> searchByPrice(int min, int max) throws SQLException {

        List<House> resultByPrice = new ArrayList<>();
        for (House requiredHouse : houses) {
            if (min < requiredHouse.getPrice() && max >= requiredHouse.getPrice()) {
                resultByPrice.add(requiredHouse);

            }
            resultByPrice.sort((o1, o2) -> -(o1.getPrice() - o2.getPrice()));
        }
        return resultByPrice;
    }

    public List<House> searchByDistrict(String text) throws SQLException {
        getHouses();
        List<House> resultByDistrict = new ArrayList<>();
        for (House requiredHouse : houses) {
            if (requiredHouse.getDistrict().toLowerCase().contains(text.toLowerCase())) {
                resultByDistrict.add(requiredHouse);
            }
            resultByDistrict.sort((o1, o2) -> o1.getUnderground().compareTo(o2.getUnderground()));
        }
        return resultByDistrict;

    }

    public List<House> getSortedBy(Comparator<House> comparator) {
        List<House> result = new LinkedList<>(houses);
        result.sort(comparator);
        return result;
    }

    public List<House> getSortedByPriceAsc() {
        return getSortedBy((o1, o2) -> o1.getPrice() - (o2.getPrice()));
    }

    public List<House> removeById(int id) throws SQLException {
        getHouses();
        List<House> result = new LinkedList<>(houses);
        result.removeIf(o -> o.getId() == id);
        return result;
    }
}
