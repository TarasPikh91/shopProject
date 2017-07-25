package com.shop.service;

import java.security.Principal;
import java.util.List;

import com.shop.entity.User;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	void save(User user, MultipartFile image) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

	void update(User user);

	void updateUserAndImage(User user, MultipartFile image);

	User findByUserLogin(String userLogin);

	User findByUuid( String uuid);

	void like(int id, Principal principal);

	User userWithCommodities(int id);

}
