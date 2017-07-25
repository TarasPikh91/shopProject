package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.AddressDao;
import com.shop.dao.CountryDao;
import com.shop.entity.Address;
import com.shop.entity.Country;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.CityDao;
import com.shop.entity.City;
import com.shop.service.CityService;
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private AddressDao addressDao;

    @Autowired
    @Qualifier("cityValidator")
    private Validator validator;

    public void save(City city, int countryId) throws Exception {

        validator.validate(city);
        Country country = countryDao.findOne(countryId);
        cityDao.saveAndFlush(city);
        city.setCountry(country);
        cityDao.save(city);

    }

    public List<City> findAll() {
        return cityDao.findAll();
    }

    public City findOne(int id) {
        return cityDao.findOne(id);
    }

    public void delete(int id) {

        City city = cityDao.cityWithAddress(id);
        for (Address address: city.getAddresses()) {
            address.setCity(null);
            addressDao.saveAndFlush(address);
        }

        cityDao.delete(id);

    }

    public void update(City city, int countryId) {
        Country country = countryDao.findOne(countryId);
        city.setCountry(country);
        cityDao.save(city);

    }

    @Override
    public City findByName(String name) {
        return cityDao.findByName(name);
    }


}
