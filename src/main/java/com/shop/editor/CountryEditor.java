package com.shop.editor;



import com.shop.entity.Country;

import java.beans.PropertyEditorSupport;

/**
 * Created by taras on 5/26/2017.
 */
public class CountryEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String idFromJsp) throws IllegalArgumentException {
        Country country = new Country();
        country.setId(Integer.parseInt(idFromJsp));
        setValue(country);
    }
}
