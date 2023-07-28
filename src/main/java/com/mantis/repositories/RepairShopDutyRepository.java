package com.mantis.repositories;

import com.mantis.data.entity.RepairShopDutyRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairShopDutyRepository  extends JpaRepository<RepairShopDutyRelation, Integer> {
}
