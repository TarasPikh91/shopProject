package com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.City;
import com.shop.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CityDao extends JpaRepository<City, Integer>{

	City findByName(String name);

	@Query("select c from City c left join fetch c.addresses where c.id=:id")
	City cityWithAddress(@Param("id") int id);


}
