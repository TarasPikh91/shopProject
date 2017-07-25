package com.shop.service;

import java.util.List;

import com.shop.entity.Guarantee;

public interface GuaranteeService {

	void save(Guarantee guarantee) throws Exception;

	List<Guarantee> findAll();

	Guarantee findOne(int id);

	void delete(int id);

	void update(Guarantee guarantee);
	Guarantee findByGuaranteeTime(String time);
}
