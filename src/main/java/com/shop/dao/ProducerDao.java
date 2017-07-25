package com.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Commodity;
import com.shop.entity.Producer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProducerDao extends JpaRepository<Producer, Integer>{

    Producer findByName(String name);
    Producer findByEmail(String emailName);

    @Query("select p from Producer p left join fetch p.commodities where p.id=:id")
    Producer producerWithCommodities(@Param("id")int id);
}
