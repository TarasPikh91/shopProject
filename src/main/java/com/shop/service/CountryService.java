package com.shop.service;

import java.util.List;

import com.shop.entity.Country;
import org.springframework.web.multipart.MultipartFile;

public interface CountryService {

	void save(Country country) throws Exception;

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	void update(Country country);

}
