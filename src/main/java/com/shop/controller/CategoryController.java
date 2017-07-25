package com.shop.controller;

import com.shop.entity.Shop;
import com.shop.service.ShopService;
import com.shop.validator.categoryValidator.CategoryValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Category;
import com.shop.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ShopService shopService;

	@GetMapping("/category")
	public String category(Model model) {
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("shops", shopService.findAll());
		return "category";
	}

	@PostMapping("/category")
	public String category(@RequestParam String categoryName, @RequestParam int shopId, Model model) throws Exception {

		Shop shop = shopService.findOne(shopId);

		Category category = new Category();
		category.setName(categoryName);
		category.setShop(shop);
		try {
			categoryService.save(category, shopId);
		}catch (Exception e){
			if(e.getMessage().equals(CategoryValidatorMessages.CATEGORY_NAME_IS_EMPTY) ||
					e.getMessage().equals(CategoryValidatorMessages.CATEGORY_NAME_IS_EXISTS)){
				model.addAttribute("categoryNameException", e.getMessage());
			}
			model.addAttribute("category", category);
			model.addAttribute("shops", shopService.findAll());
			model.addAttribute("categories", categoryService.findAll());
			return "category";

		}
		return "redirect:/category";
	}

	@GetMapping("/deleteCategory/{id}")
	public String delete(@PathVariable int id) {
		categoryService.delete(id);
		return "redirect:/category";
	}

	@GetMapping("/updateCategory/{id}")
	public String updateCategory(@PathVariable int id, Model model){
		Category category = categoryService.findOne(id);
		model.addAttribute("shops", shopService.findAll());
		model.addAttribute("currentCategory", category);
		return "updateCategory";
	}

	@PostMapping("/updateCategory/{id}")
	public String update(@PathVariable int id, @RequestParam String name, @RequestParam int shopId){
		Category category = categoryService.findOne(id);
		category.setName(name);
		categoryService.update(category, shopId);
		return "redirect:/category";
	}
}
