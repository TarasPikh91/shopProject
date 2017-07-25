package com.shop.controller;

import com.shop.entity.City;
import com.shop.service.CityService;
import com.shop.service.ShopService;
import com.shop.validator.addressValidator.AddressValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Address;
import com.shop.service.AddressService;

@Controller
public class AddressController {

	@Autowired
	private AddressService addressService;
	@Autowired
	private CityService cityService;

	@GetMapping("/address")
	public String address(Model model) {
		model.addAttribute("addresses", addressService.findAll());
		model.addAttribute("cities", cityService.findAll());
		return "address";
	}

	@PostMapping("/address")
	public String address(@RequestParam String streetName, @RequestParam String houseNumber,
						  @RequestParam String districtName, @RequestParam int cityId, Model model) throws Exception {
		City city = cityService.findOne(cityId);

		Address address = new Address();
		address.setStreet(streetName);
		address.setHouseNumber(houseNumber);
		address.setDistrict(districtName);
		address.setCity(city);

		try {
			addressService.save(address, cityId);
		}catch (Exception e){

			if (e.getMessage().equals(AddressValidatorMessages.ADDRESS_DISTRICT_EMPTY)||
					e.getMessage().equals(AddressValidatorMessages.ADDRESS_DISTRICT_NAME_IS_TOO_SMALL)){
				model.addAttribute("districtEmptyException", e.getMessage());
			}else if(e.getMessage().equals(AddressValidatorMessages.ADDRESS_HOUSE_NUMBER_EMPTY)||
					e.getMessage().equals(AddressValidatorMessages.ADDRESS_HOUSE_NUMBER_HAVE_LETTERS)){
				model.addAttribute("houseNumberException",e.getMessage());
			}else if(e.getMessage().equals(AddressValidatorMessages.ADDRESS_STREET_EMPTY)||
					e.getMessage().equals(AddressValidatorMessages.ADDRESS_STREET_IS_TOO_SMALL)) {
				model.addAttribute("streetEmptyException", e.getMessage());
			}
			model.addAttribute("address", address);
			model.addAttribute("addresses", addressService.findAll());
			model.addAttribute("cities", cityService.findAll());
			return "address";
		}
		return "redirect:/address";
	}

	@GetMapping("/deleteAddress/{id}")
	public String delete(@PathVariable int id) {
		addressService.delete(id);
		return "redirect:/address";
	}
	
	@GetMapping("/updateAddress/{id}")
	public String updateAddress(@PathVariable int id, Model model){
		
		Address address = addressService.findOne(id);
		model.addAttribute("currentAddress", address);
		model.addAttribute("cities", cityService.findAll());
		
		return"updateAddress";
	}

	@PostMapping("/updateAddress/{id}")
	public String update(@PathVariable int id, @RequestParam String streetName,
						 @RequestParam String houseNumber, @RequestParam String districtName, @RequestParam int cityId, Model model
	){


		Address address = addressService.findOne(id);
		address.setStreet(streetName);
		address.setHouseNumber(houseNumber);
		address.setDistrict(districtName);

			addressService.update(address, cityId);

		return "redirect:/address";
	}
}
