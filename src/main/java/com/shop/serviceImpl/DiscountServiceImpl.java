package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.CommodityDao;
import com.shop.entity.Commodity;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.DiscountDao;
import com.shop.entity.Discount;
import com.shop.service.DiscountService;
@Service
public class DiscountServiceImpl implements DiscountService {

	@Autowired
	private DiscountDao discountDao;

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	@Qualifier("discountValidator")
	private Validator validator;

	public void save(Discount discount) throws Exception {
		validator.validate(discount);
		discountDao.save(discount);
		
	}

	public List<Discount> findAll() {
		return discountDao.findAll();
	}

	public Discount findOne(int id) {
		return discountDao.findOne(id);
	}

	public void delete(int id) {

		Discount discount = discountDao.discountWithCommodities(id);
		for (Commodity commodity: discount.getCommodities()) {
			commodity.setDiscounts(null);
			commodityDao.saveAndFlush(commodity);
		}
		discountDao.delete(id);
		
	}

	public void update(Discount discount) {
		discountDao.save(discount);
		
	} 
	
	

}
