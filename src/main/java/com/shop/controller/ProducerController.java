package com.shop.controller;

import com.shop.entity.Address;
import com.shop.entity.Shop;
import com.shop.service.AddressService;
import com.shop.service.ShopService;
import com.shop.validator.producerValidator.ProducerValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Producer;
import com.shop.service.ProducerService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;

@Controller
public class ProducerController {

	@Autowired
	private ProducerService producerService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private AddressService addressService;


	@GetMapping("/producer")
	public String producer(Model model) {
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("shops", shopService.findAll());
		model.addAttribute("addresses", addressService.findAll());

		return "producer";
	}

	@PostMapping("/producer")
	public String save(@RequestParam String name, @RequestParam String email,
					   @RequestParam String phoneNumber, @RequestParam int shopId, @RequestParam int addressId, @RequestParam("image")MultipartFile image, Model model) throws Exception {
		Address address = addressService.findOne(addressId);
		Shop shop = shopService.findOne(shopId);

		Producer producer = new Producer();
		producer.setName(name);
		producer.setEmail(email);
		producer.setPhoneNumber(phoneNumber);
		producer.setAddress(address);
		producer.setShop(shop);

		try {
			producerService.save(producer, shopId, addressId, image);
		} catch (Exception e) {
			if(e.getMessage().equals(ProducerValidatorMessages.PRODUCER_NAME_IS_EMPTY)|| e.getMessage().equals(ProducerValidatorMessages.PRODUCER_NAME_IS_EXIST)){
				model.addAttribute("producerNameException", e.getMessage());
			}else if(e.getMessage().equals(ProducerValidatorMessages.PRODUCER_EMAIL_IS_EMPTY)||e.getMessage().equals(ProducerValidatorMessages.PRODUCER_EMAIL_IS_EXIST)){
				model.addAttribute("producerEmailException", e.getMessage());
			}else if(e.getMessage().equals(ProducerValidatorMessages.PRODUCER_PHONE_NUMBER_IS_EMPTY)||e.getMessage().equals(ProducerValidatorMessages.PRODUCER_PHONE_MUST_HAVE_ONLY_DIGITS)||
					e.getMessage().equals(ProducerValidatorMessages.PRODUCER_PHONE_MUST_HAVE_TEN_DIGITS)){
				model.addAttribute("producerPhoneNumberException", e.getMessage());
			}
			model.addAttribute("producer", producer);
			model.addAttribute("shops", shopService.findAll());
			model.addAttribute("addresses", addressService.findAll());
			return "producer";
		}
		return "redirect:/producer";
	}

	@GetMapping("/deleteProducer/{id}")
	public String delete(@PathVariable int id) {
		producerService.delete(id);
		return "redirect:/producer";
	}

	@GetMapping("/updateProducer/{id}")
	public String updateProducer(@PathVariable int id, Model model){
		Producer producer = producerService.findOne(id);
		model.addAttribute("currentProducer", producer);
		model.addAttribute("shops", shopService.findAll());
		model.addAttribute("addresses", addressService.findAll());
		return "updateProducer";
	}

	@PostMapping("/updateProducer/{id}")
	public String update(@PathVariable int id, @RequestParam String name, @RequestParam String email,
						 @RequestParam String phoneNumber, @RequestParam int shopId, @RequestParam int addressId, @RequestParam("image") MultipartFile image) throws Exception {
		Producer producer = producerService.findOne(id);
		producer.setName(name);
		producer.setEmail(email);
		producer.setPhoneNumber(phoneNumber);
		producerService.update(producer, shopId, addressId, image);
		return "redirect:/producer";
	}
}
