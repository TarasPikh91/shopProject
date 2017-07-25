package com.shop.validator.discountValidator;

/**
 * Created by taras on 6/1/2017.
 */
public interface DiscountValidatorMessages {

    String DISCOUNT_NAME_IS_EMPTY = "name field is empty";
    String DISCOUNT_NAME_IS_EXIST = "this name is exists";
    String DISCOUNT_PERCENT_IS_EMPTY = "percent field is empty";
    String DISCOUNT_PERCENT_MUST_HAVE_ONLY_DIGITS = "only digits please";
    String DISCOUNT_MUST_HAVE_AT_LEAST_THREE_LETTERS="min three letters";
}
