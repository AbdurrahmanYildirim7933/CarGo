package com.mantis.repositories;

import com.mantis.api.GarageApi;
import com.mantis.data.entity.Garage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GarageRepository extends JpaRepository<Garage, Integer> {

   @Query(value = "select  * from tbl_garage where user_id=:userId",nativeQuery = true)
   Page<Garage> getGaragesByUserId(@Param("userId") Integer userId, Pageable pageable);


   @Query(value = "select  * from tbl_garage where id=:id",nativeQuery = true)
   Page<Garage> getGaragesById(@Param("id") Integer id, Pageable pageable);


}
