package com.shop.validator.shopValidator;

import com.shop.entity.Shop;
import com.shop.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class ShopValidator implements Validator {


    
    public void validate(Object o) throws Exception {
        Shop shop = (Shop) o;

        if (shop.getName().isEmpty()){
            throw new ShopException(ShopValidatorMessages.SHOP_NAME_IS_EMPTY);
        }else if(shop.getDescription().isEmpty()){
            throw new ShopException(ShopValidatorMessages.SHOP_DESCRIPTION_IS_EMPTY);
        }else if(shop.getName().length()<3){
            throw new ShopException(ShopValidatorMessages.SHOP_NAME_IS_TOO_SHORT);
        }else if (shop.getDescription().length()<20){
            throw new ShopException(ShopValidatorMessages.SHOP_DESCRIPTION_IS_TOO_SHORT);
        }

    }
}
