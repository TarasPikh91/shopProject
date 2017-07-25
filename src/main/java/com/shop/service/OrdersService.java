package com.shop.service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import com.shop.entity.Orders;
import com.shop.entity.User;

public interface OrdersService {

	void save(int userId, List<Integer> commoditiesId);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders orders);

	void addToCart(Principal principal, int id);

	void  deleteFromCart(int userId, int commodityId);

	void buy(int userId);
}
