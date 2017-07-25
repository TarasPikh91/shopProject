package com.shop.validator.logInValidator;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.validator.Validator;
import com.shop.validator.userValidator.UserException;
import com.shop.validator.userValidator.UserValidatorMesseges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/14/2017.
 */
@Component
public class LogInValidator implements Validator {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if (user.getUserLogin().isEmpty()){
            throw new LogInException(LogInValidatorMessages.EMPTY_USER_LOGIN_FIELD);
        }else if(userDao.findByUserLogin(user.getUserLogin())== null){
            throw new LogInException((LogInValidatorMessages.WRONG_USER_LOGIN_OR_PASSWORD));
        } else if(user.getPassword().isEmpty()){
            throw new LogInException(LogInValidatorMessages.EMPTY_USER_PASSWORD);
        }else if(encoder.matches(user.getPassword(), userDao.findByUserLogin(user.getUserLogin()).getPassword())){
            throw new LogInException(LogInValidatorMessages.WRONG_USER_LOGIN_OR_PASSWORD);
        }
    }
}
