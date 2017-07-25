package com.shop.validator.producerValidator;

import com.shop.dao.ProducerDao;
import com.shop.entity.Producer;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class ProducerValidator implements Validator{

    @Autowired
    private ProducerDao producerDao;

    
    public void validate(Object o) throws Exception {

        Producer producer = (Producer) o;

        if(producer.getName().isEmpty()){
            throw new ProducerException(ProducerValidatorMessages.PRODUCER_NAME_IS_EMPTY);
        }else if(producerDao.findByName(producer.getName())!=null){
            throw new ProducerException(ProducerValidatorMessages.PRODUCER_NAME_IS_EXIST);
        }else if(producer.getEmail().isEmpty()){
            throw new ProducerException(ProducerValidatorMessages.PRODUCER_EMAIL_IS_EMPTY);
        }else if(producerDao.findByEmail(producer.getEmail())!= null){
            throw new ProducerException(ProducerValidatorMessages.PRODUCER_EMAIL_IS_EXIST);
        }else if(producer.getPhoneNumber().isEmpty()){
            throw new ProducerException(ProducerValidatorMessages.PRODUCER_PHONE_NUMBER_IS_EMPTY);
        }else if(producer.getPhoneNumber().matches("[0-9]*")==false){
            throw new ProducerException(ProducerValidatorMessages.PRODUCER_PHONE_MUST_HAVE_ONLY_DIGITS);
        }else if(producer.getPhoneNumber().length()<6){
            throw new ProducerException(ProducerValidatorMessages.PRODUCER_PHONE_MUST_HAVE_TEN_DIGITS);
        }
    }
}
