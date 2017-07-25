package com.shop.controller;

import com.shop.entity.Country;
import com.shop.validator.cityValidator.CityValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.City;
import com.shop.service.CityService;
import com.shop.service.CountryService;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/city")
    public String city(Model model) {
        model.addAttribute("cities", cityService.findAll());
        model.addAttribute("countries", countryService.findAll());
        return "city";
    }

    // @GetMapping("/city")
    // public ModelAndView city() {
    //
    // Map<String, List<City>> map = new HashMap<String, List<City>>();
    //
    // map.put("cities", cityService.findAll());
    //
    // return new ModelAndView("city", map);
    // }

    @PostMapping("/city")
    public String city(@RequestParam String cityName, @RequestParam int countryId, Model model) throws Exception {

        Country country = countryService.findOne(countryId);

        City city = new City();
        city.setName(cityName);
        city.setCountry(country);
        try {
            cityService.save(city, countryId);
        }catch (Exception e){

            if(e.getMessage().equals(CityValidatorMessages.EMPTY_CITY_MESSAGE) ||
                    e.getMessage().equals(CityValidatorMessages.EXIST_CITY_MESSAGE) ||
                    e.getMessage().equals(CityValidatorMessages.SHORT_NAME)){
                model.addAttribute("cityException", e.getMessage());
            }
            model.addAttribute("city", city);
            model.addAttribute("cities", cityService.findAll());
            model.addAttribute("countries", countryService.findAll());
            return "city";
        }

        return "redirect:/city";
    }

    @GetMapping("/deleteCity/{id}")
    public String delete(@PathVariable int id) {
        cityService.delete(id);
        return "redirect:/city";
    }

    @GetMapping("updateCity/{id}")
    public String updateCity(@PathVariable int id, Model model){
        City city = cityService.findOne(id);
        model.addAttribute("currentCity", city);
        model.addAttribute("countries", countryService.findAll());
        return "updateCity";
    }

    @PostMapping("updateCity/{cityId}")
    public String update(@PathVariable int cityId, @RequestParam int countryId, @RequestParam String name){
        City city = cityService.findOne(cityId);
        city.setName(name);
        cityService.update(city, countryId);


        return "redirect:/city";
    }

}