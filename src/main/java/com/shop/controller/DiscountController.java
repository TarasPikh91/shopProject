package com.shop.controller;

import com.shop.validator.discountValidator.DiscountValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Discount;
import com.shop.service.DiscountService;

@Controller
public class DiscountController {

	@Autowired
	private DiscountService discountService;

	@GetMapping("/discount")
	public String discount(Model model) {
		model.addAttribute("discounts", discountService.findAll());
		return "discount";
	}

	@PostMapping("/discount")
	public String saveDiscount(@RequestParam String name, @RequestParam String percent, Model model) throws Exception {

		Discount discount = new Discount();
		discount.setName(name);
		discount.setPercent(percent);

		try {
			discountService.save(discount);
		}catch (Exception e){

			if(e.getMessage().equals(DiscountValidatorMessages.DISCOUNT_NAME_IS_EMPTY)||
					e.getMessage().equals(DiscountValidatorMessages.DISCOUNT_NAME_IS_EXIST)||
					e.getMessage().equals(DiscountValidatorMessages.DISCOUNT_MUST_HAVE_AT_LEAST_THREE_LETTERS)){
				model.addAttribute("discountNameException", e.getMessage());
			}else if(e.getMessage().equals(DiscountValidatorMessages.DISCOUNT_PERCENT_IS_EMPTY)||e.getMessage().equals(DiscountValidatorMessages.DISCOUNT_PERCENT_MUST_HAVE_ONLY_DIGITS)){
				model.addAttribute("discountPercentException", e.getMessage());
			}

			model.addAttribute("discount", discount);
			model.addAttribute("discounts", discountService.findAll());
			return "discount";
		}
		return "redirect:/discount";
	}

	@GetMapping("deleteDiscount/{id}")
	public String deleteDiscount(@PathVariable int id) {
		discountService.delete(id);

		return "redirect:/discount";
	}

	@GetMapping("updateDiscount/{id}")
	public String updateDiscount(@PathVariable int id, Model model){
		Discount discount = discountService.findOne(id);
		model.addAttribute("currentDiscount", discount);
		return "updateDiscount";
	}

	@PostMapping("updateDiscount/{id}")
	public String update(@PathVariable int id, @RequestParam String name, @RequestParam String percent){
		Discount discount = discountService.findOne(id);
		discount.setName(name);
		discount.setPercent(percent);
		discountService.update(discount);
		return "redirect:/discount";
	}

}
