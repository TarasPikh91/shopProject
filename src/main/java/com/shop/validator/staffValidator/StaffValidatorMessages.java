package com.shop.validator.staffValidator;

/**
 * Created by taras on 5/31/2017.
 */
public interface StaffValidatorMessages {

    String EMPTY_STAFF_FIRST_NAME = "field the firstName is empty";
    String EXIST_STAFF_FIRST_NAME = "field the  firstName already exist";
    String EMPTY_STAFF_LAST_NAME = "field the lastName is empty";
    String EXIST_STAFF_LAST_NAME = "field the lastName already exist";
    String EMPTY_STAFF_EMAIL = "field the email is empty";
    String EXIST_STAFF_EMAIL = "the email is exist";
    String EMPTY_STAFF_PHONE = "field the userPhone is empty";
    String STAFF_PHONE_NUMBER_HAVE_LETTERS = "only number please";
    String STAFF_PHONE_NUMBER_MUST_HAVE_TEN_DIGITS = "at least 10 digits";
}
