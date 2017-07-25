package com.shop.validator.discountValidator;

import com.shop.dao.DiscountDao;
import com.shop.entity.Discount;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class DiscountValidator implements Validator {

    @Autowired
    private DiscountDao discountDao;

   
    public void validate(Object o) throws Exception {
        Discount discount = (Discount) o;

        if(discount.getName().isEmpty()){
            throw new DiscountException(DiscountValidatorMessages.DISCOUNT_NAME_IS_EMPTY);
        }else if(discountDao.findByName(discount.getName()) != null){
            throw new DiscountException(DiscountValidatorMessages.DISCOUNT_NAME_IS_EXIST);
        }else if(discount.getPercent().isEmpty()){
            throw new DiscountException(DiscountValidatorMessages.DISCOUNT_PERCENT_IS_EMPTY);
        }else if(discount.getPercent().matches("[0-9]*") == false){
            throw new DiscountException(DiscountValidatorMessages.DISCOUNT_PERCENT_MUST_HAVE_ONLY_DIGITS);
        }else if(discount.getName().length()<3){
            throw new DiscountException(DiscountValidatorMessages.DISCOUNT_MUST_HAVE_AT_LEAST_THREE_LETTERS);
        }
     }
}
