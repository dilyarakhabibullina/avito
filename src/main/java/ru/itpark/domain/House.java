package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class House {
    private int id;
    private String name;
    private String district;
    private int price;
    private String underground;
    private int rooms;
    private int square;
}