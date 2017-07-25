package com.shop.service;

import java.util.List;

import com.shop.entity.City;

public interface CityService {


	void save(City city, int countryId) throws Exception;

	List<City> findAll();

	City findOne(int id);

	void delete(int id);

	void update(City city, int countryId);

	City findByName(String name);
}
