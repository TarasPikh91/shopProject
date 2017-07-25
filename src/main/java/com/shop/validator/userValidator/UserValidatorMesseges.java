package com.shop.validator.userValidator;

/**
 * Created by taras on 5/29/2017.
 */
public interface UserValidatorMesseges {

    String EMPTY_USERFIRST_NAME_FIELD = "field firstName is empty";
    String EMPTY_USERLAST_NAME_FIELD = "field lastName is empty";
    String EMPTY_USERLOGIN = "field Login is empty";
    String EXIST_USERLOGIN = "user is exist";
    String EMPTY_USERPASSWORD = "field password is empty";
    String EMPTY_USEREMAIL = "field email is empty";
    String EXIST_USEREMAIL = "email is exist";
    String EMPTY_USERPHONE = "field phone is empty";
    String EMPTY_USERAGE = "field age is empty";
    String USER_AGE_FIELD_HAVE_LETTERS = "only number please";
    String SMALL_USER_PASSWORD="password is to small";
    String USER_PHONE_NUMBER_HAVE_LETTERS = "only number please";
    String USER_PHONE_NUMBER_MUST_HAVE_TEN_DIGITS = "at least ten digits";
    String TOO_LONG_USER_AGE = "user age is too long";
}
