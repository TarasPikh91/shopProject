package com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Category;
import com.shop.entity.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    Category findByName(String categoryName);

    @Query("select c from Category c left join fetch c.commodities where c.id=:id")
    Category categoryWithCommodities(@Param("id")int id);
}
