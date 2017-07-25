package com.shop.controller;


import com.shop.entity.Category;
import com.shop.entity.Email;
import com.shop.entity.Guarantee;
import com.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class IndexController {

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private MailSendlerService mailSendlerService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ShopService shopService;

	@GetMapping("/")
	public String index(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("commodities", commodityService.findAllPages(pageable));
		model.addAttribute("commodityCategory", commodityService.commodityWithCategoriesPages(pageable));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("shops", shopService.findAll());
		return "index";
	}

	@PostMapping("/")
	public String indexAfterLogIn(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("commodities", commodityService.findAllPages(pageable));
		model.addAttribute("commodityCategory", commodityService.commodityWithCategoriesPages(pageable));
		model.addAttribute("categories", categoryService.findAll());


		model.addAttribute("shops", shopService.findAll());
		return "index";
	}

	@PostMapping("/email")
	public String email(@RequestParam String name, Model model, @PageableDefault Pageable pageable) {

		Email email = new Email();
		email.setName(name);

		emailService.save(email);


		String after = "thanks";
		String mailBody = "http://localhost:8078/";
		mailSendlerService.sendMail(after, mailBody, email.getName());
		return "redirect://";
	}



	@GetMapping("/login")
	public String login(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("commodities", commodityService.findAllPages(pageable));
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("shops", shopService.findAll());
		model.addAttribute("commodityCategory", commodityService.commodityWithCategoriesPages(pageable));
		return "index";
	}

}
