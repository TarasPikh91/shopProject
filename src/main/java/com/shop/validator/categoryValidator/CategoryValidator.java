package com.shop.validator.categoryValidator;

import com.shop.dao.CategoryDao;
import com.shop.entity.Category;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by taras on 6/1/2017.
 */
@Component
public class CategoryValidator implements Validator {

    @Autowired
    private CategoryDao categoryDao;

    public void validate(Object o) throws Exception {
        Category category = (Category) o;

        if(category.getName().isEmpty()){
            throw new CategoryException(CategoryValidatorMessages.CATEGORY_NAME_IS_EMPTY);
        }else if(categoryDao.findByName(category.getName()) != null){
            throw  new CategoryException(CategoryValidatorMessages.CATEGORY_NAME_IS_EXISTS);
        }
    }
}
