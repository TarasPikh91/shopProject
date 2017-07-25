package com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryDao extends JpaRepository<Country, Integer> {

    Country findByName(String name);

    @Query("select c from Country c left join fetch c.cities where c.id=:id")
    Country countryWithCity(@Param("id") int id);
}
