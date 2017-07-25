package com.shop.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import com.shop.dao.CommodityDao;
import com.shop.entity.Commodity;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.GuaranteeDao;
import com.shop.entity.Guarantee;
import com.shop.service.GuaranteeService;

@Service
public class GuaranteeServiceImpl implements GuaranteeService {

	@Autowired
	private GuaranteeDao guaranteeDao;

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	@Qualifier("guaranteeValidator")
	private Validator validator;


	public void save(Guarantee guarantee) throws Exception {

		validator.validate(guarantee);
		guaranteeDao.save(guarantee);
	}

	public List<Guarantee> findAll() {
		return guaranteeDao.findAll();
	}

	public Guarantee findOne(int id) {
		return guaranteeDao.findOne(id);
	}

	public void delete(int id) {

		Guarantee guarantee = guaranteeDao.guaranteeWithCommodities(id);
		for (Commodity commodity : guarantee.getCommodities()) {
			commodity.setGuarantee(null);
			commodityDao.saveAndFlush(commodity);
		}

		guaranteeDao.delete(id);
	}

	public void update(Guarantee guarantee) {
		guaranteeDao.save(guarantee);
	}

	@Override
	public Guarantee findByGuaranteeTime(String time) {
		return guaranteeDao.findByGuaranteeTime(time);
	}

}
