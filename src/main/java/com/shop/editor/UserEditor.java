package com.shop.editor;

import com.shop.entity.User;

import java.beans.PropertyEditorSupport;

/**
 * Created by taras on 6/13/2017.
 */
public class UserEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        User user = new User();
        user.setId(Integer.parseInt(text));
    }
}
