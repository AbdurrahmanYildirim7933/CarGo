package com.mantis.repositories;

import com.mantis.data.entity.Garage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage, Integer> {

   @Query(value = "select  * from tbl_garage where user_id=:userId",nativeQuery = true)
   List<Garage> getGaragesByUserId(@Param("userId") Integer userId);

   //List<Garage> getGaragesByUserId(Integer user_id);

}
