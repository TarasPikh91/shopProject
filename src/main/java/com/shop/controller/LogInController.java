package com.shop.controller;

import com.shop.entity.User;
import com.shop.service.CategoryService;
import com.shop.service.CommodityService;
import com.shop.service.ShopService;
import com.shop.service.UserService;
import com.shop.validator.Validator;
import com.shop.validator.logInValidator.LogInValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by taras on 6/14/2017.
 */
@Controller
public class LogInController {

    @Autowired
    private UserService userService;

    @Autowired
   private CategoryService categoryService;

    @Autowired
    @Qualifier("logInValidator")
    private Validator validator;

    @GetMapping("/logIn")
    public String logIn(Model model) {
        return "logIn";
    }

    @GetMapping("/index")
    public String index(){

        return "index";
    }

    @PostMapping("/logIn")
    public String logInAfter(Model model) {
//        model.addAttribute("categories", categoryService.findAll());
        return "index";
    }

    @PostMapping("/failureLogin")
    public String userLogIn(Model model, @RequestParam String userLogin,
                            @RequestParam String password) throws Exception{

        try {
            validator.validate(new User(userLogin, password));
        } catch (Exception e) {
            if(e.getMessage().equals(LogInValidatorMessages.EMPTY_USER_LOGIN_FIELD)||
                    e.getMessage().equals(LogInValidatorMessages.EMPTY_USER_PASSWORD)||
                    e.getMessage().equals(LogInValidatorMessages.WRONG_USER_LOGIN_OR_PASSWORD)){
                model.addAttribute("logInException", e.getMessage());
            }
            return "logIn";
        }
        model.addAttribute("user", new User());
//        model.addAttribute("categories", categoryService.findAll());

        return "index";
    }

}
