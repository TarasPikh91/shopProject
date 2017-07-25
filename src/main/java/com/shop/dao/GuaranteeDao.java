package com.shop.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Commodity;
import com.shop.entity.Guarantee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GuaranteeDao extends JpaRepository<Guarantee, Integer> {


    @Query("select g from Guarantee g left join fetch g.commodities where g.id=:id")
    Guarantee guaranteeWithCommodities(@Param("id")int id);

    Guarantee findByGuaranteeTime(String time);
}
