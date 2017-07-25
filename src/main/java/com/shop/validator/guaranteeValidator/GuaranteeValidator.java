package com.shop.validator.guaranteeValidator;

import com.shop.dao.GuaranteeDao;
import com.shop.entity.Guarantee;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class GuaranteeValidator implements Validator {

    @Autowired
    GuaranteeDao guaranteeDao;

    
    public void validate(Object o) throws Exception {
        Guarantee guarantee = (Guarantee) o;
        if (guarantee.getGuaranteeTime().isEmpty()){
            throw new GuaranteeException(GuaranteeValidatorMessages.GUARANTEE_TIME_EMPTY);
        }else if(guaranteeDao.findByGuaranteeTime(guarantee.getGuaranteeTime())!=null) {
            throw  new GuaranteeException(GuaranteeValidatorMessages.GUARANTEE_ALREADY_EXISTS);
        } else if(guarantee.getGuaranteeTime().matches("[0-9]*")==false){
            throw new GuaranteeException(GuaranteeValidatorMessages.GUARANTEE_TIME_MUST_HAVE_ONLY_DIGITS);
        }else if(guarantee.getGuaranteeTime().length()>2){
            throw new GuaranteeException(GuaranteeValidatorMessages.GUARANTEE_MAX_DIGITS);
        }
    }
}
