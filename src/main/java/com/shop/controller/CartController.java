package com.shop.controller;

import com.shop.dao.CommodityDao;
import com.shop.service.CommodityService;
import com.shop.service.OrdersService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

/**
 * Created by taras on 6/15/2017.
 */
@Controller
public class CartController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/cart")
    public String Cart(Model model, Principal principal){
        model.addAttribute("user", userService.userWithCommodities(Integer.parseInt(principal.getName())));
//        model.addAttribute("orders", ordersService.findAll());
        return "cart";
    }

}
