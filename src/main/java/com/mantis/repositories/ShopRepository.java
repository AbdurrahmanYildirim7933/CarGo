package com.mantis.repositories;

import com.mantis.data.entity.Garage;
import com.mantis.data.entity.Shop;
import com.mantis.data.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer>{
    @Query(value = "select * from tbl_shop where name ilike %:name%",nativeQuery = true)
    List<Shop> findShopByName(@Param("name") String name);
 

    List<Shop> findByName(String name);


}