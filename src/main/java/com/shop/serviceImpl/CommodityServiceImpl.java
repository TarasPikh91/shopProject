package com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.*;
import com.shop.entity.*;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shop.service.CommodityService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommodityServiceImpl implements CommodityService {

	@Autowired
	private CommodityDao commodityDao;
	@Autowired
	private GuaranteeDao guaranteeDao;
	@Autowired
	private ProducerDao producerDao;

	@Autowired
	private DiscountDao discountDao;
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	@Qualifier("commodityValidator")
	private Validator validator;

	public void save(Commodity commodity, List<Integer> discountsId, int guaranteeId,
					 int producerId, List<Integer> categoriesId, MultipartFile image) throws Exception {

		validator.validate(commodity);
		commodityDao.saveAndFlush(commodity);
		String path = System.getProperty("catalina.home")+"/resources/"+
				commodity.getName()+"/"+image.getOriginalFilename();

		commodity.setPathImage("resources/" + commodity.getName()+"/"
				+image.getOriginalFilename());

		File filePath = new File(path);
		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		List<Discount> discounts = new ArrayList<Discount>();
		for (Integer id : discountsId){
			discounts.add(discountDao.findOne(id));
		}

		List<Category> categories = new ArrayList<Category>();
		for (Integer id: categoriesId) {
			categories.add(categoryDao.findOne(id));
		}

		Guarantee guarantee = guaranteeDao.findOne(guaranteeId);
		Producer producer = producerDao.findOne(producerId);

		commodity.setGuarantee(guarantee);
		commodity.setProducer(producer);
		commodity.setDiscounts(discounts);
		commodity.setCategories(categories);

		commodityDao.save(commodity);

	}

	public List<Commodity> findAll() {
		return commodityDao.findAll();
	}

	public void update(Commodity commodity, List<Integer> discountsId, int guaranteeId,
					   int producerId, List<Integer> categoriesId, MultipartFile image) {

		String path = System.getProperty("catalina.home")+"/resources/"+
				commodity.getName()+"/"+image.getOriginalFilename();

		commodity.setPathImage("resources/" + commodity.getName()+"/"+image.getOriginalFilename());

		File filePath = new File(path);
		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}
		List<Discount> discounts = new ArrayList<Discount>();
		for (Integer id: discountsId) {
			Discount discount = discountDao.findOne(id);
			discounts.add(discount);
		}


		List<Category> categories = new ArrayList<Category>();
		for (Integer id: categoriesId){
			Category category = categoryDao.findOne(id);
			categories.add(category);
		}




		Guarantee guarantee = guaranteeDao.findOne(guaranteeId);
		Producer producer = producerDao.findOne(producerId);

		commodity.setDiscounts(discounts);
		commodity.setGuarantee(guarantee);
		commodity.setProducer(producer);
		commodity.setCategories(categories);

		commodityDao.save(commodity);

	}

	public Commodity findOne(int id) {
		return commodityDao.findOne(id);
	}

	public void delete(int id) {
		commodityDao.delete(id);

	}
	@Override
	public Page<Commodity> findAllPages(Pageable pageable) {
		return commodityDao.findAll(pageable);
	}

	@Override
	public Page<Commodity> commodityWithCategoriesPages(Pageable pageable) {
		return commodityDao.commodityWithCategoriesPages(pageable);
	}

	@Override
	public Commodity commodityWithDiscounts(int id) {
		return commodityDao.commodityWithDiscounts(id);
	}

	@Override
	public Commodity commodityWithCategories(int id) {
		return commodityDao.commodityWithCategories(id);
	}
}



