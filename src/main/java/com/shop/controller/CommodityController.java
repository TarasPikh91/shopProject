package com.shop.controller;

import com.shop.entity.*;
import com.shop.service.*;
import com.shop.validator.commodityValidator.CommodityValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommodityController {

	@Autowired
	private CommodityService commodityService;
	@Autowired
	private DiscountService discountService;
	@Autowired
	private GuaranteeService guaranteeService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private ProducerService producerService;
	@Autowired
	private UserService userService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/commodity")
	private String commodity(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("commoditiesWithCategory", commodityService.commodityWithCategoriesPages(pageable));
		model.addAttribute("commodities", commodityService.findAllPages(pageable));
		model.addAttribute("discounts", discountService.findAll());
		model.addAttribute("guarantees", guaranteeService.findAll());
		model.addAttribute("orders",ordersService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return "commodity";
	}

	@PostMapping("/commodity")
	private String commodity(@RequestParam String commodityName, @RequestParam String commodityPrice,
						@RequestParam String commodityDescription, @RequestParam List<Integer> discountsId,
						@RequestParam int guaranteeId, @RequestParam int producerId,
						@RequestParam List<Integer> categoriesId, Model model, @RequestParam("image") MultipartFile image, @PageableDefault Pageable pageable) throws Exception {

		List<Discount> discounts = new ArrayList<Discount>();
		for (Integer id : discountsId){
			discounts.add(discountService.findOne(id));
		}

		List<Category> categories = new ArrayList<Category>();
		for (Integer id : categoriesId){
			categories.add(categoryService.findOne(id));
		}

		Guarantee guarantee = guaranteeService.findOne(guaranteeId);
		Producer producer = producerService.findOne(producerId);

		Commodity commodity = new Commodity();
		commodity.setName(commodityName);
		commodity.setPrice(commodityPrice);
		commodity.setDescription(commodityDescription);
		commodity.setGuarantee(guarantee);
		commodity.setProducer(producer);
		commodity.setDiscounts(discounts);
		commodity.setCategories(categories);

		try {
			commodityService.save(commodity, discountsId, guaranteeId, producerId, categoriesId, image);
		}catch (Exception e){

			if(e.getMessage().equals(CommodityValidatorMessages.COMMODITY_NAME_IS_EMPTY)){
				model.addAttribute("commodityNameException", e.getMessage());
			}else if(e.getMessage().equals(CommodityValidatorMessages.COMMODITY_PRICE_IS_EMPTY) ||
					e.getMessage().equals(CommodityValidatorMessages.COMMODITY_PRICE_HAVE_LETTERS)){
				model.addAttribute("commodityPriceException", e.getMessage());
			}else if(e.getMessage().equals(CommodityValidatorMessages.COMMODITY_DESCRIPTION_IS_EMPTY)){
				model.addAttribute("commodityDescriptionException", e.getMessage());
			}

			model.addAttribute("Commodity", commodity);
			model.addAttribute("commodities", commodityService.findAllPages(pageable));
			model.addAttribute("discounts", discountService.findAll());
			model.addAttribute("guarantees", guaranteeService.findAll());
			model.addAttribute("orders",ordersService.findAll());
			model.addAttribute("producers", producerService.findAll());
			model.addAttribute("categories", categoryService.findAll());

				return "commodity";
		}
		return "redirect:/commodity";
	}

	@GetMapping("/deleteCommodity/{id}")
	public String delete(@PathVariable int id) {
		commodityService.delete(id);

		return "redirect:/commodity";

	}

	@GetMapping("/updateCommodity/{id}")
	public String updateCommodity(@PathVariable int id, Model model, @PageableDefault Pageable pageable){
		Commodity commodity = commodityService.findOne(id);
		model.addAttribute("currentCommodity", commodity);
		model.addAttribute("discounts", discountService.findAll());
		model.addAttribute("guaranties", guaranteeService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("commmodityWithDiscount", commodityService.commodityWithDiscounts(id));
		model.addAttribute("commodityWithCategory", commodityService.commodityWithCategories(id));

		return "updateCommodity";
	}

	@PostMapping("/updateCommodity/{id}")
	public String update(@PathVariable int id, @RequestParam String commodityName, @RequestParam String commodityPrice, @RequestParam String commodityDescription,
						 @RequestParam List<Integer> discountsId, @RequestParam int guaranteeId, @RequestParam int producerId,
						  @RequestParam List<Integer> categoriesId, @RequestParam("image") MultipartFile image){
		Commodity commodity = commodityService.findOne(id);
		commodity.setName(commodityName);
		commodity.setPrice(commodityPrice);
		commodity.setDescription(commodityDescription);
		commodityService.update(commodity, discountsId, guaranteeId, producerId, categoriesId, image);
		return "redirect:/commodity";
	}

}
