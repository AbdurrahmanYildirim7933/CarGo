
package com.mantis.logic;

import com.mantis.data.entity.RepairShop;
import com.mantis.data.entity.RepairShopDutyRelation;
import com.mantis.repositories.RepairShopDutyRepository;
import com.mantis.repositories.RepairShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RepairShopLogic {
    @Autowired
    RepairShopRepository repairShopRepository;
    @Autowired
    RepairShopDutyRepository repairShopDutyRepository;

    public RepairShop createService(RepairShop repairShop) {
        return repairShopRepository.save(repairShop);
    }

    public RepairShopDutyRelation createRepairShopDuty(RepairShopDutyRelation repairShopDutyRelation) {
        return repairShopDutyRepository.save(repairShopDutyRelation);
    }

}