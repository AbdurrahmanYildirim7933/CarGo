package com.mantis.repositories;

import com.mantis.data.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<Car,Integer> {
    @Query(value = "select  * from tbl_car where garage_id=:id",nativeQuery = true)
    Page<Car> getCarsByGarageId(@Param("id") Integer id, Pageable pageable);


}
