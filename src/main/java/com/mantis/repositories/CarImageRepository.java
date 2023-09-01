package com.mantis.repositories;

import com.mantis.data.entity.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage,Integer> {
}
