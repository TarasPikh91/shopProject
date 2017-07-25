package com.shop.service;





import com.shop.entity.Email;

import java.util.List;

/**
 * Created by taras on 6/28/2017.
 */
public interface EmailService {

    void save(Email email);

    List<Email> findAll();

    void findOne(int id);

    void delete(int id);

    void update(Email email);



}
