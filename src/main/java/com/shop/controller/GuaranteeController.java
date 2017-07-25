package com.shop.controller;

import java.sql.Time;
import java.time.LocalDate;

import com.shop.validator.guaranteeValidator.GuaranteeValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Guarantee;
import com.shop.service.GuaranteeService;

@Controller
public class GuaranteeController {

	@Autowired
	private GuaranteeService guaranteeService;

	@GetMapping("/guarantee")
	public String guarantee(Model model){
		model.addAttribute("guaranties", guaranteeService.findAll());
		return "guarantee";
	}

	@PostMapping("/guarantee")
	public String save(@RequestParam String guaranteeTime, Model model) throws Exception {
		Guarantee guarantee = new Guarantee();
		guarantee.setStartTime(LocalDate.now());
		guarantee.setGuaranteeTime(guaranteeTime);
		if (guaranteeTime.matches("[0-9]*")== true && guaranteeTime.isEmpty()==false) {
			Integer GT = Integer.valueOf(guaranteeTime);
			guarantee.setEndTime(guarantee.getStartTime().plusMonths(GT));
		}else{

		}
		try {
			guaranteeService.save(guarantee);
		}catch (Exception e){
			if(e.getMessage().equals(GuaranteeValidatorMessages.GUARANTEE_TIME_EMPTY)|| e.getMessage().equals(GuaranteeValidatorMessages.GUARANTEE_TIME_MUST_HAVE_ONLY_DIGITS)||
					e.getMessage().equals(GuaranteeValidatorMessages.GUARANTEE_ALREADY_EXISTS)||
					e.getMessage().equals(GuaranteeValidatorMessages.GUARANTEE_MAX_DIGITS)){
				model.addAttribute("guaranteeTimeException", e.getMessage());
			}
			model.addAttribute("guarantee", guarantee);
			model.addAttribute("guaranties", guaranteeService.findAll());
			return "guarantee";
		}
		return "redirect:/guarantee";
	}

	@GetMapping("/deleteGuarantee/{id}")
	public String delete(@PathVariable int id) {
		guaranteeService.delete(id);
		return "redirect:/guarantee";
	}

	@GetMapping("/updateGuarantee/{id}")
	public String updateGuarantee(@PathVariable int id, Model model){
		Guarantee guarantee = guaranteeService.findOne(id);
		model.addAttribute("currentGuarantee", guarantee);
		return "updateGuarantee";
	}

	@PostMapping("/updateGuarantee/{id}")
	public String update(@PathVariable int id, @RequestParam String guaranteeTime){
		Guarantee guarantee = guaranteeService.findOne(id);
//		guarantee.setEndTime(guarantee.getStartTime().plusMonths(guaranteeTime));
		guarantee.setGuaranteeTime(guaranteeTime);
		guaranteeService.update(guarantee);
		return "redirect:/guarantee";
	}

}
