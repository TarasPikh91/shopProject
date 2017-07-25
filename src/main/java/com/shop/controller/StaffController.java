package com.shop.controller;

import com.shop.entity.Address;
import com.shop.entity.Shop;
import com.shop.service.AddressService;
import com.shop.service.ShopService;
import com.shop.validator.staffValidator.StaffValidatorMessages;
import com.shop.validator.userValidator.UserValidatorMesseges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Staff;
import com.shop.service.StaffService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class StaffController {

	@Autowired
	private StaffService staffService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private ShopService shopService;

	@GetMapping("/staff")
	public String staff(Model model) {
		model.addAttribute("staffs", staffService.findAll());
		model.addAttribute("addresses", addressService.findAll());
		model.addAttribute("shops", shopService.findAll());
		return "staff";
	}

	@PostMapping("/staff")
	public String save(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
					   @RequestParam String phoneNumber, @RequestParam int addressId,
					   @RequestParam int shopId, Model model, @RequestParam MultipartFile image) throws Exception {
		Address address = addressService.findOne(addressId);
		Shop shop = shopService.findOne(shopId);

		Staff staff = new Staff();
		staff.setFirstName(firstName);
		staff.setLastName(lastName);
		staff.setEmail(email);
		staff.setPhoneNumber(phoneNumber);
		staff.setAddress(address);
		staff.setShop(shop);

		try {
			staffService.save(staff, addressId, shopId, image);
		}catch (Exception e){
			if (e.getMessage().equals(StaffValidatorMessages.EMPTY_STAFF_FIRST_NAME) || e.getMessage().equals(StaffValidatorMessages.EXIST_STAFF_FIRST_NAME)){
				model.addAttribute("emptyStaffFirstNameException",e.getMessage());
			}else if(e.getMessage().equals(StaffValidatorMessages.EMPTY_STAFF_LAST_NAME)||e.getMessage().equals(StaffValidatorMessages.EXIST_STAFF_LAST_NAME) ) {
				model.addAttribute("emptyStaffLastNameException", e.getMessage());
			}else if(e.getMessage().equals(StaffValidatorMessages.EMPTY_STAFF_EMAIL)|| e.getMessage().equals(StaffValidatorMessages.EXIST_STAFF_EMAIL)) {
				model.addAttribute("emptyStaffEmailException", e.getMessage());
			}else if(e.getMessage().equals(StaffValidatorMessages.EMPTY_STAFF_PHONE)|| e.getMessage().equals(StaffValidatorMessages.STAFF_PHONE_NUMBER_HAVE_LETTERS)||
					e.getMessage().equals(StaffValidatorMessages.STAFF_PHONE_NUMBER_MUST_HAVE_TEN_DIGITS)){
				model.addAttribute("emptyStaffPhoneException", e.getMessage());
			}
			model.addAttribute("staff", staff);
			model.addAttribute("staffs", staffService.findAll());
			model.addAttribute("addresses", addressService.findAll());
			model.addAttribute("shops", shopService.findAll());


		return "staff";
		}
		return "redirect:/staff";
	}

	@GetMapping("/deleteStaff/{id}")
	public String delete(@PathVariable int id) {
		staffService.delete(id);
		return "redirect:/staff";
	}

	@GetMapping("/updateStaff/{id}")
	public String updateStaff(@PathVariable int id, Model model){
		Staff staff = staffService.findOne(id);
		model.addAttribute("currentStaff", staff);
		model.addAttribute("addresses", addressService.findAll());
		model.addAttribute("shops", shopService.findAll());
		model.addAttribute("staffs", staffService.findAll());
		return "updateStaff";
	}

	@PostMapping("/updateStaff/{id}")
	public String update(@PathVariable int id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
						 @RequestParam String phoneNumber, @RequestParam int addressId, @RequestParam int shopId, @RequestParam("image") MultipartFile image){



		Staff staff = staffService.findOne(id);

		staff.setFirstName(firstName);
		staff.setLastName(lastName);
		staff.setEmail(email);
		staff.setPhoneNumber(phoneNumber);
		staffService.update(staff, addressId, shopId, image);
		return "redirect:/staff";
	}

}
