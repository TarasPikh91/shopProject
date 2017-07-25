package com.shop.serviceImpl;


import com.shop.dao.EmailDao;
import com.shop.entity.Email;
import com.shop.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by taras on 6/28/2017.
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailDao emailDao;

    @Override
    public void save(Email email) {
        emailDao.save(email);
    }

    @Override
    public List<Email> findAll() {
        return emailDao.findAll();
    }

    @Override
    public void findOne(int id) {
        emailDao.findOne(id);
    }

    @Override
    public void delete(int id) {

        emailDao.delete(id);
    }

    @Override
    public void update(Email email) {
        emailDao.save(email);
    }
}
