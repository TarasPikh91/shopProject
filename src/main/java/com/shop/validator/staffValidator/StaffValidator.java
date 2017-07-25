package com.shop.validator.staffValidator;

import com.shop.dao.StaffDao;
import com.shop.entity.Staff;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 5/31/2017.
 */
@Component
public class StaffValidator implements Validator{

    @Autowired
    private StaffDao staffDao;

   
    public void validate(Object o) throws Exception {
        Staff staff = (Staff) o;

        if(staff.getFirstName().isEmpty()){
            throw new StaffException(StaffValidatorMessages.EMPTY_STAFF_FIRST_NAME);
        }else if(staffDao.findByFirstName(staff.getFirstName())!=null){
            throw new StaffException(StaffValidatorMessages.EXIST_STAFF_FIRST_NAME);
        }else if(staff.getLastName().isEmpty()){
            throw new StaffException(StaffValidatorMessages.EMPTY_STAFF_LAST_NAME);
        }else if(staffDao.findByLastName(staff.getLastName()) != null){
            throw new StaffException(StaffValidatorMessages.EXIST_STAFF_LAST_NAME);
        }else if(staff.getEmail().isEmpty()){
            throw new StaffException(StaffValidatorMessages.EMPTY_STAFF_EMAIL);
        }else if(staffDao.findByEmail(staff.getEmail())!=null){
            throw new StaffException(StaffValidatorMessages.EXIST_STAFF_EMAIL);
        }else if(staff.getPhoneNumber().isEmpty()){
            throw new StaffException(StaffValidatorMessages.EMPTY_STAFF_PHONE);
        }else if(staff.getPhoneNumber().matches("[0-9]*")==false){
            throw new StaffException(StaffValidatorMessages.STAFF_PHONE_NUMBER_HAVE_LETTERS);
        }else if(staff.getPhoneNumber().length()<10){
            throw new StaffException(StaffValidatorMessages.STAFF_PHONE_NUMBER_MUST_HAVE_TEN_DIGITS);
        }
    }
}
