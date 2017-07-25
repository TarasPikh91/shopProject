package com.shop.service;

import java.util.List;

import com.shop.entity.Shop;

public interface ShopService {

	void save(Shop shop, int addressId) throws Exception;

	List<Shop> findAll();

	Shop findOne(int id);

	void delete(int id);

	void update(Shop shop, int addressId);
}
