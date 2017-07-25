package com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import com.shop.dao.CommodityDao;
import com.shop.entity.Commodity;
import com.shop.entity.Role;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private CommodityDao commodityDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void save(User user, MultipartFile image) throws Exception {

		validator.validate(user);
		String path = System.getProperty("catalina.home") + "/resources/"
				+ user.getUserLogin() + "/" + image.getOriginalFilename();

		user.setPathImage("resources/" + user.getUserLogin() + "/" + image.getOriginalFilename());

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}

		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {

		User user = userDao.userWithCommodities(id);
		for (Commodity commodity: user.getCommodities()) {
			commodity.setUsers(null);
			commodityDao.saveAndFlush(commodity);
		}

		userDao.delete(id);
	}

	public void update(User user) {
		userDao.save(user);
	}

	@Override
	public void updateUserAndImage(User user, MultipartFile image) {
		String path = System.getProperty("catalina.home")+"/resources/"+
				user.getUserLogin()+"/"+image.getOriginalFilename();

		user.setPathImage("resources/"+user.getUserLogin()+"/"+image.getOriginalFilename());

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}
		userDao.save(user);
	}


	@Override
	public User findByUserLogin(String userLogin) {
		return userDao.findByUserLogin(userLogin);
	}

	@Override
	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userLogin) throws UsernameNotFoundException {
		return userDao.findByUserLogin(userLogin);
	}

	@Override
	public void like(int id, Principal principal) {

		Commodity commodity = commodityDao.findOne(id);
		User user = userDao.userWithCommodities(Integer.parseInt(principal.getName()));
		user.getCommodities().add(commodity);
		userDao.save(user);
	}

	@Override
	public User userWithCommodities(int id) {
		return userDao.userWithCommodities(id);
	}



}
