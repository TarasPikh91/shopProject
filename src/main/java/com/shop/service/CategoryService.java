package com.shop.service;

import java.util.List;

import com.shop.entity.Category;
import org.springframework.data.repository.query.Param;

public interface CategoryService{

	
	public void save(Category category, int shopId) throws Exception;
	
	public List<Category> findAll();
	
	public Category findOne(int id);
	
	public void delete(int id);

	Category categoryWithCommodities(int id);
	
	public void update(Category category, int shopId);

	Category findByName(String categoryName);

}

