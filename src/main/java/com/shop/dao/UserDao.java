package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUserLogin(String userLogin);
    User findByEmail(String userEmail);

    @Query("select u from User u left join fetch u.commodities where u.id=:id")
    User userWithCommodities(@Param("id")int id);

    @Query("select u from User u where u.uuid=:uuid")
    User findByUuid(@Param("uuid") String uuid);
}
