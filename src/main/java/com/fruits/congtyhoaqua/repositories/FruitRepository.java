package com.fruits.congtyhoaqua.repositories;

import com.fruits.congtyhoaqua.models.Fruit;
import com.fruits.congtyhoaqua.models.Manufacture;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;
@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    Set<Fruit> findAllByDateCreatedBetween(LocalDate afterDate,LocalDate beforeDate);

    @Query("select f from Fruit f where f.name like concat('%', ?1, '%')")
    Set<Fruit> findAllByNameContaining(String name);

//    Set<Fruit> findAllByNameContains(String name);

    @Query("select f from Fruit f where f.manufacture = ?1")
    Set<Fruit> findAllByManufacture(Manufacture manufacture);

    @Query("select f from Fruit f where f.priceOut > ?1 and f.priceOut < ?2")
    Set<Fruit> findAllByPriceOutGreaterThanAndPriceOutLessThan(Integer greaterPrice, Integer lessPrice);

}
