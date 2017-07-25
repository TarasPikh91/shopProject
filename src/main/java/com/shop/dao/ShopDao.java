package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShopDao extends JpaRepository<Shop, Integer> {


    @Query("select s from Shop s left join fetch s.staff where s.id=:id")
    Shop shopWithStaff(@Param("id") int id);

    @Query("select s from Shop s left join fetch s.producers where s.id=:id")
    Shop shopWithProducer(@Param("id") int id);

    @Query("select s from Shop s left join fetch s.categories where s.id=:id")
    Shop shopWithCategory(@Param("id")int id);
}
