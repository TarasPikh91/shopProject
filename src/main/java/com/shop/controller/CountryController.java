package com.shop.controller;


import com.shop.validator.countryValidator.CountryValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Country;
import com.shop.service.CountryService;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CountryController {



//	@PostMapping("/country")
//	public void loadCountry(@RequestBody Country country){
//		System.out.println(country.getName());
//
//	}
	@Autowired
	private CountryService countryService;

	@GetMapping("/country")
	public String country(Model model){
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("country", new Country());
		return "country";
	}

	@PostMapping("/country")
	public String save(@ModelAttribute Country country, Model model) throws Exception {
		try {
			countryService.save(country);
		}catch (Exception e){
			if (e.getMessage().equals(CountryValidatorMessages.EMPTY_COUNTRY_NAME)||
					e.getMessage().equals(CountryValidatorMessages.EXIST_COUNTRY_NAME)||
			e.getMessage().equals(CountryValidatorMessages.COUNTRY_MUST_HAVE_ONLY_LETTERS)||
			e.getMessage().equals(CountryValidatorMessages.COUNTRY_NAME_IS_TOO_SHORT)){
				model.addAttribute("countryNameException", e.getMessage());
			}
			model.addAttribute("country", country);
			model.addAttribute("countries", countryService.findAll());
			return "country";
		}
		return "redirect:/country";
	}

	@GetMapping("deleteCountry/{id}")
	public String delete(@PathVariable int id){
		countryService.delete(id);
		return "redirect:/country";
	}

	@GetMapping("/updateCountry/{id}")
	public String updateCountry(@PathVariable int id, Model model) {
		Country country = countryService.findOne(id);
		model.addAttribute("currentCountry", country);
		return "updateCountry";
	}

	@PostMapping("updateCountry/{id}")
	public String update(@PathVariable int id, @RequestParam String name, Model model){

		Country country = countryService.findOne(id);
		country.setName(name);
			countryService.update(country);
		return "redirect:/country";
	}

}
