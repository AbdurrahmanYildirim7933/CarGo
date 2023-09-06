package com.mantis.repositories;

import com.mantis.data.entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarImageRepository extends JpaRepository<CarImage,Integer> {
    @Query(value = "select  * from tbl_car_image where car=:carId",nativeQuery = true)
    List<CarImage> getImagesByCar(@Param("carId") Integer carId);
}
