package com.shop.validator.countryValidator;

import com.shop.dao.CountryDao;
import com.shop.entity.Country;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class CountryValidator implements Validator {

    @Autowired
    private CountryDao countryDao;

    public void validate(Object o) throws Exception {
        Country country = (Country) o;

        if (country.getName().isEmpty()){
            throw new CountryException(CountryValidatorMessages.EMPTY_COUNTRY_NAME);
        }else if(countryDao.findByName(country.getName()) != null ){
            throw new CountryException(CountryValidatorMessages.EXIST_COUNTRY_NAME);
        }else if (country.getName().matches(".*\\d+.*")){
            throw new CountryException(CountryValidatorMessages.COUNTRY_MUST_HAVE_ONLY_LETTERS);
        }else if(country.getName().length()<3){
            throw new CountryException(CountryValidatorMessages.COUNTRY_NAME_IS_TOO_SHORT);
        }
    }
}
