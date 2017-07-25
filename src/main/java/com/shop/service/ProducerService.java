package com.shop.service;

import java.util.List;

import com.shop.entity.Producer;
import org.springframework.web.multipart.MultipartFile;

public interface ProducerService {

	void save(Producer producer, int shopId, int addressId, MultipartFile image) throws Exception;

	List<Producer> findAll();

	Producer findOne(int id);

	void delete(int id);

	void update(Producer producer, int shopId, int addressId, MultipartFile image);

}
