package com.shop.editor;


import com.shop.entity.City;

import java.beans.PropertyEditorSupport;

/**
 * Created by taras on 5/26/2017.
 */
public class CityEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String idFromJsp) throws IllegalArgumentException {

        City city = new City();
        city.setId(Integer.parseInt(idFromJsp));

        setValue(city);
    }
}
