package com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.shop.dao.CityDao;
import com.shop.entity.City;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.CountryDao;
import com.shop.entity.Country;
import com.shop.service.CountryService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Autowired
	private CityDao cityDao;

	@Autowired
	@Qualifier("countryValidator")
	private Validator validator;

	public void save(Country country) throws Exception {

		validator.validate(country);
		country.setName(country.getName().toUpperCase());
		countryDao.save(country);

	}

	public List<Country> findAll() {
		return countryDao.findAll();
	}

	public Country findOne(int id) {
		return countryDao.findOne(id);
	}

	public void delete(int id) {
		
		Country country = countryDao.countryWithCity(id);

		for (City city : country.getCities()) {

			city.setCountry(null);
			cityDao.saveAndFlush(city);
		}
		
		
		countryDao.delete(id);
	}

	public void update(Country country) {
		country.setName(country.getName().toUpperCase());
		countryDao.save(country);
	}

}
