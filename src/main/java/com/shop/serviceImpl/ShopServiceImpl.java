package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.*;
import com.shop.entity.*;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private ProducerDao producerDao;
	@Autowired
	private CategoryDao categoryDao;


	@Autowired
	@Qualifier("shopValidator")
	private Validator validator;

	public void save(Shop shop, int addressId) throws Exception {
		validator.validate(shop);
		Address address = addressDao.findOne(addressId);
		shopDao.saveAndFlush(shop);
		shop.setAddress(address);
		shopDao.save(shop);
	}

	public List<Shop> findAll() {
		return shopDao.findAll();
	}

	public Shop findOne(int id) {
		return shopDao.findOne(id);
	}

	public void delete(int id) {

		Shop shop = shopDao.shopWithStaff(id);
		for (Staff staff : shop.getStaff()) {
			staff.setShop(null);
			staffDao.saveAndFlush(staff);
		}

		shop = shopDao.shopWithProducer(id);
		for(Producer producer : shop.getProducers()){
			producer.setShop(null);
			producerDao.saveAndFlush(producer);
		}

		shop = shopDao.shopWithCategory(id);
		for (Category category : shop.getCategories()){
			category.setShop(null);
			categoryDao.saveAndFlush(category);
		}

		shopDao.delete(id);

	}

	public void update(Shop shop, int addressId) {
		Address address = addressDao.findOne(addressId);
		shop.setAddress(address);
		shopDao.save(shop);

	}

}
