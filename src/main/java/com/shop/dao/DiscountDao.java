package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Discount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DiscountDao extends JpaRepository<Discount, Integer> {

    Discount findByName(String name);

    @Query("select d from Discount d left join fetch d.commodities where d.id=:id")
    Discount discountWithCommodities(@Param("id") int id);
}
