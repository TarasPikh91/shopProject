package com.shop.controller;


import com.shop.service.MailSendlerService;
import com.shop.validator.Validator;
import com.shop.validator.logInValidator.LogInValidatorMessages;
import com.shop.validator.userValidator.UserValidatorMesseges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.User;
import com.shop.service.UserService;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.UUID;

@Controller
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailSendlerService mailSendlerService;

	@GetMapping("/userRegistration")
	public String registration(Model model) {

		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());
		return "userRegistration";
	}

	@PostMapping("/userRegistration")
	public String registration(@ModelAttribute User user, Model model, @RequestParam MultipartFile image) throws Exception {

		String uuid = UUID.randomUUID().toString();
		user.setUuid(uuid);
		try {
			userService.save(user, image);
		}catch (Exception e){
			if(e.getMessage().equals(UserValidatorMesseges.EMPTY_USERFIRST_NAME_FIELD)){
				model.addAttribute("userFirstNameException", e.getMessage());
			}else if(e.getMessage().equals(UserValidatorMesseges.EMPTY_USERLAST_NAME_FIELD)){
				model.addAttribute("userLastNameException", e.getMessage());
			}else if(e.getMessage().equals(UserValidatorMesseges.EMPTY_USERLOGIN) || e.getMessage().equals(UserValidatorMesseges.EXIST_USERLOGIN)){
				model.addAttribute("userLoginException", e.getMessage());
			}else if(e.getMessage().equals(UserValidatorMesseges.EMPTY_USERPASSWORD) || e.getMessage().equals(UserValidatorMesseges.SMALL_USER_PASSWORD) ){
				model.addAttribute("userPasswordException", e.getMessage());
			}else if (e.getMessage().equals(UserValidatorMesseges.EMPTY_USEREMAIL)|| e.getMessage().equals(UserValidatorMesseges.EXIST_USEREMAIL)){
				model.addAttribute("userEmailException", e.getMessage());
			}else if(e.getMessage().equals(UserValidatorMesseges.EMPTY_USERPHONE) || e.getMessage().equals(UserValidatorMesseges.USER_PHONE_NUMBER_HAVE_LETTERS) ||
					e.getMessage().equals(UserValidatorMesseges.USER_PHONE_NUMBER_MUST_HAVE_TEN_DIGITS)){
				model.addAttribute("userPhoneException", e.getMessage());
			}else if(e.getMessage().equals(UserValidatorMesseges.EMPTY_USERAGE) || e.getMessage().equals(UserValidatorMesseges.USER_AGE_FIELD_HAVE_LETTERS)||
					e.getMessage().equals(UserValidatorMesseges.TOO_LONG_USER_AGE)){
				model.addAttribute("userAgeException", e.getMessage());
			}

			model.addAttribute("users", userService.findAll());
			return "userRegistration";
		}
		String theme = "thanks for registration";
		String mailBody = "http://localhost:8078/confirm/"+ uuid;
		mailSendlerService.sendMail(theme,mailBody,user.getEmail());
		return "logIn";
	}

	@GetMapping("/deleteUserRegistration/{id}")
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/userRegistration";
	}

	@GetMapping("/updateUserRegistration/{id}")
	public String updateRegistration(@PathVariable int id, Model model){
		User user = userService.findOne(id);
		model.addAttribute("currentRegistration", user);
		return "updateUserRegistration";
	}

	@PostMapping("/updateUserRegistration/{id}")
	public String update(@PathVariable int id, @RequestParam String userFirstName, @RequestParam String userLastName, @RequestParam String userLogin,
						 @RequestParam String userEmail, @RequestParam String userPassword, @RequestParam String userAge, @RequestParam String phoneNumber, @RequestParam MultipartFile image) throws Exception {

		MultipartFile file = image;

		User user = userService.findOne(id);
		user.setFirstName(userFirstName);
		user.setLastName(userLastName);
		user.setUserLogin(userLogin);
		user.setEmail(userEmail);
		user.setPassword(userPassword);
		user.setAge(userAge);
		user.setPhoneNumber(phoneNumber);
		user.setPathImage(file.toString());
			userService.updateUserAndImage(user, image);
		return "redirect:/userRegistration";
	}

	@GetMapping("/like/{id}")
	public String like(@PathVariable int id, Principal principal){
		userService.like(id, principal);
		return "redirect:/";
	}

	@GetMapping("/confirm/{uuid}")
	public String confirm(@PathVariable String uuid) throws Exception {
		User user = userService.findByUuid(uuid);
		user.setEnable(true);

		userService.update(user);

		return "redirect:/";
	}
}
