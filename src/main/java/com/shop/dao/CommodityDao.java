package com.shop.dao;

import java.util.List;

import com.shop.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommodityDao extends JpaRepository<Commodity, Integer> {

    @Query(value = "select c from Commodity c left join fetch c.categories",
    countQuery = "select count(c.id) from Commodity c")
    Page<Commodity> commodityWithCategoriesPages(Pageable pageable);

    @Query("select c from Commodity c left join fetch c.discounts where c.id=:id")
    Commodity commodityWithDiscounts(@Param("id")int id);
//
    @Query("select c from Commodity c left join fetch c.categories where c.id=:id")
    Commodity commodityWithCategories(@Param("id") int id);


}

