package com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Shop;
import com.shop.entity.Staff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StaffDao extends JpaRepository<Staff, Integer> {

    Staff findByFirstName(String firstName);
    Staff findByLastName(String lastName);
    Staff findByEmail(String email);

    @Query("select s from Staff s where s.pathImage=:pathImage")
    Staff staffWithImage(@Param("pathImage")String pathImage);
}
