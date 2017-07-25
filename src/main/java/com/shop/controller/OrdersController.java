package com.shop.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Orders;
import com.shop.service.OrdersService;

@Controller
public class OrdersController {

	@Autowired
	private OrdersService ordersService;

	@Autowired
	private UserService userService;

	@GetMapping("/addToCart/{id}")
	public String buy(@PathVariable int id, Principal principal){

		ordersService.addToCart(principal, id);

		return "redirect:/";
	}

	@GetMapping("deleteFromCart/{userId}/{commodityId}")
	public String deleteFromCart(@PathVariable int userId, @PathVariable int commodityId){

		ordersService.deleteFromCart(userId, commodityId);

		return "redirect:/cart";
	}

//	@PostMapping("/orders")
//	public String save(@RequestParam int userId, @RequestParam List<Integer> commoditiesId) {
//		ordersService.save(userId, commoditiesId);
//		return "redirect:/orders";
//	}


		@PostMapping("/buy/{id}")
		public String createNewOrder(@PathVariable int id){


			ordersService.buy(id);



			return "redirect:/";
		}



}
