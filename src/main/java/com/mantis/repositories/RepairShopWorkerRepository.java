package com.mantis.repositories;

import com.mantis.data.entity.RepairShop;
import com.mantis.data.entity.RepairShopWorkers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairShopWorkerRepository extends JpaRepository<RepairShopWorkers, Integer> {
}
