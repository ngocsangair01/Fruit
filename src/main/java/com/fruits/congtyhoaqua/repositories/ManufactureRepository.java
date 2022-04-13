package com.fruits.congtyhoaqua.repositories;

import com.fruits.congtyhoaqua.models.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {
    Set<Manufacture> findAllByName(String name);
}
