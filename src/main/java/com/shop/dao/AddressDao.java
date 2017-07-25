package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressDao extends JpaRepository<Address, Integer> {


    @Query("select a from Address a left join fetch a.shops where a.id=:id")
    Address addressWithShop(@Param("id") int id);

    @Query("select a from Address a left join fetch a.staffs where a.id=:id")
    Address addressWithStaff(@Param("id") int id);

    @Query("select a from  Address a left join fetch a.producer where a.id=:id")
    Address addressWithProducer(@Param("id") int id);
}
