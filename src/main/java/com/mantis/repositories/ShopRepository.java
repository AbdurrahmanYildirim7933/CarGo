package com.mantis.repositories;

import com.mantis.data.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer>{

}