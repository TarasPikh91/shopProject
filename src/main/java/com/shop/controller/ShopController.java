package com.shop.controller;

import com.shop.entity.Address;
import com.shop.service.AddressService;
import com.shop.validator.shopValidator.ShopValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Shop;
import com.shop.service.ShopService;

@Controller
public class ShopController {

	@Autowired
	private ShopService service;
	@Autowired
	private AddressService addressService;

	@GetMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("shops", service.findAll());
		model.addAttribute("addresses", addressService.findAll());
		return "/shop";
	}

	@PostMapping("/shop")
	public String save(@RequestParam String name, @RequestParam String description,
					   @RequestParam int addressId, Model model) throws Exception {
		Address address = addressService.findOne(addressId);
		Shop shop = new Shop();

		shop.setName(name);
		shop.setDescription(description);
		shop.setAddress(address);
		try {
			service.save(shop, addressId);
		} catch (Exception e) {
			if (e.getMessage().equals(ShopValidatorMessages.SHOP_NAME_IS_EMPTY)||
					e.getMessage().equals(ShopValidatorMessages.SHOP_NAME_IS_TOO_SHORT)){
				model.addAttribute("shopNameException", e.getMessage());
			}else if(e.getMessage().equals(ShopValidatorMessages.SHOP_DESCRIPTION_IS_EMPTY)||
					e.getMessage().equals(ShopValidatorMessages.SHOP_DESCRIPTION_IS_TOO_SHORT)){
				model.addAttribute("shopDescriptionException", e.getMessage());
			}
			model.addAttribute("shop", shop);
			model.addAttribute("addresses", addressService.findAll());
			return "shop";
		}

		return "redirect:/shop";
	}

	@GetMapping("/deleteShop/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/shop";
	}

	@GetMapping("/updateShop/{id}")
	public String updateShop(@PathVariable int id, Model model){
		Shop shop = service.findOne(id);
		model.addAttribute("currentShop", shop);
		model.addAttribute("addresses", addressService.findAll());
		return "updateShop";
	}

	@PostMapping("/updateShop/{id}")
	public String update(@PathVariable int id, @RequestParam String name, @RequestParam String description,
						 @RequestParam int addressId){
		Shop shop = service.findOne(id);
		shop.setName(name);
		shop.setDescription(description);
		service.update(shop, addressId);
		return "redirect:/shop";
	}

}
