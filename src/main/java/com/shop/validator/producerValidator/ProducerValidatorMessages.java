package com.shop.validator.producerValidator;

/**
 * Created by taras on 6/1/2017.
 */
public interface ProducerValidatorMessages {

    String PRODUCER_NAME_IS_EMPTY = "name is empty";
    String PRODUCER_NAME_IS_EXIST = "name is exist";
    String PRODUCER_EMAIL_IS_EMPTY = "email is empty";
    String PRODUCER_EMAIL_IS_EXIST = "email is exist";
    String PRODUCER_PHONE_NUMBER_IS_EMPTY = "phone is empty";
    String PRODUCER_PHONE_MUST_HAVE_ONLY_DIGITS = "only digits please";
    String PRODUCER_PHONE_MUST_HAVE_TEN_DIGITS = "at least ten digits";

}
