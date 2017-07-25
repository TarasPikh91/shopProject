package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.*;
import com.shop.entity.*;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.service.AddressService;
@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao addressDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private ProducerDao producerDao;

	@Autowired
	@Qualifier("addressValidator")
	private Validator validator;
	
	public void save(Address address, int cityId) throws Exception {
	 	validator.validate(address);
		City city = cityDao.findOne(cityId);
		addressDao.saveAndFlush(address);
		address.setCity(city);
		addressDao.save(address);
		
	}

	public List<Address> findAll() {
		return addressDao.findAll();
	}

	public Address findOne(int id) {
		return addressDao.findOne(id);
	}

	public void delete(int id) {

		Address address = addressDao.addressWithStaff(id);
		for (Staff staff: address.getStaffs()) {
			staff.setAddress(null);
			staffDao.saveAndFlush(staff);
		}

		address = addressDao.addressWithProducer(id);
		if (address.getProducer() !=null){
			Producer producer = address.getProducer();
			producer.setAddress(null);
			producerDao.saveAndFlush(producer);
		}



		address = addressDao.addressWithShop(id);
		for (Shop shop: address.getShops()) {
			shop.setAddress(null);
			shopDao.saveAndFlush(shop);
            }

		addressDao.delete(id);
		
	}

	public void update(Address address, int cityId){
		City city = cityDao.findOne(cityId);
		address.setCity(city);
		addressDao.save(address);
		
	}

	

}
