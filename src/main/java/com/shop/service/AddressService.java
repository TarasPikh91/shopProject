package com.shop.service;

import java.util.List;

import com.shop.entity.Address;

public interface AddressService {

	void save(Address address, int cityId) throws Exception;

	List<Address> findAll();

	Address findOne(int id);

	void delete(int id);

	void update(Address address, int cityId);
	
}
