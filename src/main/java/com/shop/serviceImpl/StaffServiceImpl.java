package com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.shop.dao.AddressDao;
import com.shop.dao.ShopDao;
import com.shop.entity.Address;
import com.shop.entity.Shop;
import com.shop.validator.Validator;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.StaffDao;
import com.shop.entity.Staff;
import com.shop.service.StaffService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private ShopDao shopDao;

	@Autowired
	@Qualifier("staffValidator")
	private Validator validator;

	public void save(Staff staff, int addressId, int shopId, MultipartFile image) throws Exception {
		validator.validate(staff);
		String path = System.getProperty("catalina.home")+"/resources/"+
				staff.getLastName()+"/"+image.getOriginalFilename();

		staff.setPathImage("resources/" + staff.getLastName()+"/"
				+image.getOriginalFilename());

		File filePath = new File(path);
		try {
			filePath.mkdirs();
			try {
			FileUtils.cleanDirectory(new File(System.getProperty("catalina.home")+"/resources/"+
					staff.getLastName()+"/"+image.getOriginalFilename()));
		}catch(IOException e){
			e.printStackTrace();
		}
			image.transferTo(filePath);
		}
		catch (IOException e){
			System.out.println("error with file");
		}

		Address address = addressDao.findOne(addressId);
		Shop shop = shopDao.findOne(shopId);
		staff.setAddress(address);
		staff.setShop(shop);
		staffDao.saveAndFlush(staff);
		staffDao.save(staff);
		
	}

	public List<Staff> findAll() {
		return staffDao.findAll();
	}

	public Staff findOne(int id) {
		return staffDao.findOne(id);
	}

	public void delete(int id) {
		staffDao.delete(id);
		
	}

	public void update(Staff staff, int addressId, int shopId, MultipartFile image) {

		String path = System.getProperty("catalina.home")+"/resources/"+staff.getLastName()+"/"+image.getOriginalFilename();

		staff.setPathImage("resources/"+staff.getLastName()+"/"+image.getOriginalFilename());

		File filePath = new File(path);

		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error upload file");
		}

		Address address = addressDao.findOne(addressId);
		Shop shop = shopDao.findOne(shopId);
		staff.setAddress(address);
		staff.setShop(shop);

		staffDao.save(staff);
	}

	@Override
	public Staff staffWithImage(String pathImage) {
		return staffDao.staffWithImage( pathImage);
	}
}
