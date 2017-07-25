package com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.shop.dao.AddressDao;
import com.shop.dao.CommodityDao;
import com.shop.dao.ShopDao;
import com.shop.entity.Address;
import com.shop.entity.Commodity;
import com.shop.entity.Shop;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.ProducerDao;
import com.shop.entity.Producer;
import com.shop.service.ProducerService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerDao producerDao;
	@Autowired
	private ShopDao shopDao;

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	private AddressDao addressDao;

	@Autowired
	@Qualifier("producerValidator")
	private Validator validator;

	public void save(Producer producer, int shopId, int addressId, MultipartFile image) throws Exception {
		validator.validate(producer);

		String path = System.getProperty("catalina.home")+"/resources/"+
				producer.getName()+"/"+image.getOriginalFilename();

		producer.setPathImage("resources/" + producer.getName()+"/"
				+image.getOriginalFilename());

		File filePath = new File(path);
		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		Shop shop = shopDao.findOne(shopId);
		producer.setShop(shop);
		Address address = addressDao.findOne(addressId);
		producer.setAddress(address);
		producerDao.saveAndFlush(producer);
		producerDao.save(producer);

		
	}

	public List<Producer> findAll() {
		return producerDao.findAll();
	}

	public Producer findOne(int id) {
		return producerDao.findOne(id);
	}

	public void delete(int id) {

		Producer producer = producerDao.producerWithCommodities(id);
		for (Commodity commodity: producer.getCommodities()) {
			commodity.setProducer(null);
			commodityDao.saveAndFlush(commodity);
		}
		producerDao.delete(id);
		
	}

	public void update(Producer producer, int shopId, int addressId, MultipartFile image) {

		String path = System.getProperty("catalina.home")+"/resources/"
				+ producer.getName()+"/"+image.getOriginalFilename();

		producer.setPathImage("resources/"+producer.getName()+"/"+image.getOriginalFilename());

		File filePath = new File(path);

		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		Shop shop = shopDao.findOne(shopId);
		producer.setShop(shop);
		Address address = addressDao.findOne(addressId);
		producer.setAddress(address);

		producerDao.save(producer);
	}

}
