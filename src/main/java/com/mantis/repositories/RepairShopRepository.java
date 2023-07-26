
package com.mantis.repositories;

import com.mantis.data.entity.RepairShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairShopRepository extends JpaRepository<RepairShop, Integer> {
}