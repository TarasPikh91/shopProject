package com.shop.validator.addressValidator;

/**
 * Created by taras on 6/1/2017.
 */
public interface AddressValidatorMessages {

    String ADDRESS_STREET_EMPTY = "the field street is empty";
    String ADDRESS_HOUSE_NUMBER_EMPTY = "the field houseNumber is empty";
    String ADDRESS_DISTRICT_EMPTY = "the field district is empty";
    String ADDRESS_HOUSE_NUMBER_HAVE_LETTERS = "only number please";
    String ADDRESS_STREET_IS_TOO_SMALL = "the field street is too small";
    String ADDRESS_DISTRICT_NAME_IS_TOO_SMALL = "the field district is to small";
}
