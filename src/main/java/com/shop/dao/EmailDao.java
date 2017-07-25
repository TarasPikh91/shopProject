package com.shop.dao;


import com.shop.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by taras on 6/28/2017.
 */
public interface EmailDao extends JpaRepository<Email, Integer> {

}
