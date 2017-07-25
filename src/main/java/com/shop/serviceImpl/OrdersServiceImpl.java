package com.shop.serviceImpl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.shop.dao.CommodityDao;
import com.shop.dao.UserDao;
import com.shop.entity.Commodity;
import com.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.OrdersDao;
import com.shop.entity.Orders;
import com.shop.service.OrdersService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private UserDao userDao;

	public void save(int userId, List<Integer> commoditiesId) {

		Orders orders = new Orders();
		orders.setDate(LocalDate.now());

		List<Commodity> commodities = new ArrayList<Commodity>();
		for (Integer id: commoditiesId) {
			commodities.add(commodityDao.findOne(id));
		}
		orders.setCommodities(new ArrayList<Commodity>());
		User user = userDao.findOne(userId);
		orders.setUser(user);
		ordersDao.saveAndFlush(orders);
		ordersDao.save(orders);
		
	}

	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	public Orders findOne(int id) {
		return ordersDao.findOne(id);
	}

	public void delete(int id) {
		ordersDao.delete(id);
		
	}

	public void update(Orders orders) {
		ordersDao.save(orders);
		
	}

	@Override
	public void addToCart(Principal principal, int id) {
		User user = userDao.userWithCommodities(Integer.parseInt(principal.getName()));
		Commodity commodity = commodityDao.findOne(id);
		Orders orders = ordersDao.findOne(id);
		user.getCommodities().add(commodity);
		userDao.save(user);

	}


	@Override
	@Transactional
	public void deleteFromCart(int userId, int commodityId) {
		User user = userDao.userWithCommodities(userId);

		Commodity commodity = commodityDao.findOne(commodityId);

		user.getCommodities().remove(commodity);
		userDao.save(user);
	}

	@Override
	@Transactional
	public void buy(int userId) {
		Orders orders = new Orders();
		orders.setDate(LocalDate.now());
		ordersDao.saveAndFlush(orders);

		User user = userDao.userWithCommodities(userId);

		orders.setUser(user);
//		Integer totalPrice = 0;
		for (Commodity commodity:user.getCommodities()) {
			orders.getCommodities().add(commodity);
//			totalPrice +=Integer.parseInt(commodity.getPrice());
//			orders.setTotalPrice(commodity.getPrice());
			ordersDao.save(orders);
			user.setCommodities(user.getCommodities());
//			userDao.saveAndFlush(user);
		}


//		user.getCommodities().clear();
		userDao.save(user);
	}
}
