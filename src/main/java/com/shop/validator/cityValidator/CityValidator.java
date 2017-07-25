package com.shop.validator.cityValidator;

import com.shop.dao.CityDao;
import com.shop.entity.City;
import com.shop.entity.Country;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class CityValidator implements Validator {

    @Autowired
    private CityDao cityDao;


    public void validate(Object o) throws Exception {

        City city = (City) o;
        if(city.getName().isEmpty()){
            throw new CityException(CityValidatorMessages.EMPTY_CITY_MESSAGE);
        }else if(cityDao.findByName(city.getName()) != null){
            throw new CityException(CityValidatorMessages.EXIST_CITY_MESSAGE);
        }else if(city.getName().length() < 3){
            throw new CityException(CityValidatorMessages.SHORT_NAME);
        }
    }
}
