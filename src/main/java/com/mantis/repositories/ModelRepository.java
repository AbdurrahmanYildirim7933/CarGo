package com.mantis.repositories;

import com.mantis.data.entity.Garage;
import com.mantis.data.entity.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Integer> {

    @Query(value = "select  * from tbl_model where brand=:brandId",nativeQuery = true)
    List<Model> getModelsByBrand(@Param("brandId") Integer brandId);
}
