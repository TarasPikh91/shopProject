package com.shop.validator.addressValidator;

import com.shop.dao.AddressDao;
import com.shop.entity.Address;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class AddressValidator implements Validator {

    @Autowired
    AddressDao addressDao;

    public void validate(Object o) throws Exception {

        Address address = (Address) o;

        if (address.getStreet().isEmpty()){
            throw new AddressException(AddressValidatorMessages.ADDRESS_STREET_EMPTY);
        }else if(address.getHouseNumber().isEmpty()){
            throw new AddressException(AddressValidatorMessages.ADDRESS_HOUSE_NUMBER_EMPTY);
        }else if(address.getDistrict().isEmpty()){
            throw new AddressException(AddressValidatorMessages.ADDRESS_DISTRICT_EMPTY);
        }else if(address.getHouseNumber().matches("[0-9.]*") == false){
            throw  new AddressException(AddressValidatorMessages.ADDRESS_HOUSE_NUMBER_HAVE_LETTERS);
        }else if(address.getStreet().length()<3){
            throw new AddressException(AddressValidatorMessages.ADDRESS_STREET_IS_TOO_SMALL);
        }else if(address.getDistrict().length()<3){
            throw new AddressException(AddressValidatorMessages.ADDRESS_DISTRICT_NAME_IS_TOO_SMALL);
        }

    }
}
