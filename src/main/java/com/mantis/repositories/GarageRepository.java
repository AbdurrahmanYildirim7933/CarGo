package com.mantis.repositories;

import com.mantis.data.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Integer> {
}
