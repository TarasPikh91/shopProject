package com.shop.service;

import java.util.List;

import com.shop.entity.Staff;
import org.springframework.web.multipart.MultipartFile;

public interface StaffService {

	void save(Staff staff, int addressId, int shopId, MultipartFile image) throws Exception;

	List<Staff> findAll();

	Staff findOne(int id);

	void delete(int id);

	void update(Staff staff, int addressId, int shopId, MultipartFile image);

	Staff staffWithImage(String pathImage);

}
