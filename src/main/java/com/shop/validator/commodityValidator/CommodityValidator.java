package com.shop.validator.commodityValidator;

import com.shop.entity.Commodity;
import com.shop.validator.Validator;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class CommodityValidator implements Validator {


    public void validate(Object o) throws Exception {

        Commodity commodity = (Commodity) o;

        if(commodity.getName().isEmpty()){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_NAME_IS_EMPTY);
        }else if(commodity.getPrice().isEmpty()){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_PRICE_IS_EMPTY);
        }else if(commodity.getPrice().matches("[0-9.]*")== false){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_PRICE_HAVE_LETTERS);
        }else if(commodity.getDescription().isEmpty()){
            throw new CommodityException(CommodityValidatorMessages.COMMODITY_DESCRIPTION_IS_EMPTY);
        }

    }
}
