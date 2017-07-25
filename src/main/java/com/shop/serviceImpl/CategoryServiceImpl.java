package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.ShopDao;
import com.shop.entity.Shop;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.CategoryDao;
import com.shop.entity.Category;
import com.shop.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ShopDao shopDao;

	@Autowired
	@Qualifier("categoryValidator")
	private Validator validator;

	public void save(Category category, int shopId) throws Exception {
		validator.validate(category);
		Shop shop = shopDao.findOne(shopId);
		categoryDao.saveAndFlush(category);
		category.setShop(shop);
		categoryDao.save(category);

	}

	public List<Category> findAll() {

		return categoryDao.findAll();
	}

	public Category findOne(int id) {
		return categoryDao.findOne(id);
	}

	public void delete(int id) {
		categoryDao.delete(id);

	}

	@Override
	public Category categoryWithCommodities(int id) {
		return categoryDao.categoryWithCommodities(id);
	}

	public void update(Category category, int shopId) {
		Shop shop = shopDao.findOne(shopId);
		category.setShop(shop);
		categoryDao.save(category);

	}

	@Override
	public Category findByName(String categoryName) {
		return categoryDao.findByName(categoryName);
	}


}
