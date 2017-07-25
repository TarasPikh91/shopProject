package com.shop.service;

import java.util.List;

import com.shop.entity.Discount;

public interface DiscountService {

	void save(Discount discount) throws Exception;

	List<Discount> findAll();

	Discount findOne(int id);

	void delete(int id);

	void update(Discount discount);
}
