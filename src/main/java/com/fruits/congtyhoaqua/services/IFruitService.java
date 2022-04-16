package com.fruits.congtyhoaqua.services;

import com.fruits.congtyhoaqua.dtos.FruitDTO;
import com.fruits.congtyhoaqua.models.Fruit;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface IFruitService {
    Set<Fruit> getAllFruits();
    Fruit createFruit(Integer idManufacture, FruitDTO fruitDTO);
    Fruit editAvatarFruit(Integer idFruit, MultipartFile avatar);
    Fruit editFruit(Integer idFruit,FruitDTO fruitDTO);
    Fruit deleteFruit(Integer idFruit);
    Fruit getById(Integer idFruit);
    Set<Fruit> getAllByDay(String afterDate, String beforeDate);
    Set<Fruit> getAllByPrice(Integer greaterPrice, Integer lessPrice);
    Set<Fruit> getAllByManufacture(Integer idManufacture);
    Set<Fruit> getAllByName(String name);
    Set<Fruit> getAllByExpiry(String expiry);
    Set<Fruit> getAllFruitByCategory(Integer idCategory);
    Set<Fruit> filter(
            String idCategory,
            String dayBefore,
            String dayAfter,
            Integer greaterPrice,
            Integer lessPrice,
            String manufacture,
            String name,
            String expiry);
}
