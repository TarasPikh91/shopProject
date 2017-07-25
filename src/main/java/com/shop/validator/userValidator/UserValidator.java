package com.shop.validator.userValidator;


import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 5/29/2017.
 */
@Component
public class UserValidator implements Validator{

    @Autowired
    private UserDao userDao;

   
    public void validate(Object o) throws Exception {
        User user = (User) o;

        if(user.getFirstName().isEmpty()){
            throw new UserException(UserValidatorMesseges.EMPTY_USERFIRST_NAME_FIELD);
        }else if(user.getLastName().isEmpty()){
          throw new UserException(UserValidatorMesseges.EMPTY_USERLAST_NAME_FIELD);
        }else if(user.getUserLogin().isEmpty()){
           throw new UserException(UserValidatorMesseges.EMPTY_USERLOGIN);
           }else if(userDao.findByUserLogin(user.getUserLogin()) != null){
                throw new UserException(UserValidatorMesseges.EXIST_USERLOGIN);
            }else if(user.getPassword().isEmpty()){
               throw new UserException(UserValidatorMesseges.EMPTY_USERPASSWORD);
        }else if(user.getPassword().length()<8){
                throw new UserException(UserValidatorMesseges.SMALL_USER_PASSWORD);
        }else if(user.getEmail().isEmpty()){
                throw new UserException(UserValidatorMesseges.EMPTY_USEREMAIL);
        }else if(userDao.findByEmail(user.getEmail()) != null){
            throw new UserException(UserValidatorMesseges.EXIST_USEREMAIL);
        }else if(user.getPhoneNumber().isEmpty()){
            throw new UserException(UserValidatorMesseges.EMPTY_USERPHONE);
        }else if(user.getAge().isEmpty()){
            throw new UserException(UserValidatorMesseges.EMPTY_USERAGE);
        } else if(user.getAge().matches("[0-9.]*") == false){
            throw new UserException(UserValidatorMesseges.USER_AGE_FIELD_HAVE_LETTERS);
        }else if(user.getPhoneNumber().matches("[0-9]*") == false){
            throw new UserException(UserValidatorMesseges.USER_PHONE_NUMBER_HAVE_LETTERS);
        }else if(user.getPhoneNumber().length()<10){
            throw new UserException(UserValidatorMesseges.USER_PHONE_NUMBER_MUST_HAVE_TEN_DIGITS);
        }else if(user.getAge().length()>3){
            throw new UserException(UserValidatorMesseges.TOO_LONG_USER_AGE);
        }
    }
}
