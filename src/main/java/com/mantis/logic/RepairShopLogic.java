
package com.mantis.logic;

import com.mantis.data.entity.RepairShop;
import com.mantis.data.entity.RepairShopDutyRelation;
import com.mantis.data.entity.RepairShopWorkers;
import com.mantis.repositories.RepairShopDutyRepository;
import com.mantis.repositories.RepairShopRepository;
import com.mantis.repositories.RepairShopWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RepairShopLogic {
    @Autowired
    RepairShopRepository repairShopRepository;
    @Autowired
    RepairShopDutyRepository repairShopDutyRepository;
    @Autowired
    RepairShopWorkerRepository repairShopWorkerRepository;

    public RepairShop createService(RepairShop repairShop) {
        return repairShopRepository.save(repairShop);
    }

    public RepairShopDutyRelation createRepairShopDuty(RepairShopDutyRelation repairShopDutyRelation) {
        return repairShopDutyRepository.save(repairShopDutyRelation);
    }

    public RepairShopWorkers createRepairShopWorkers(RepairShopWorkers repairShopWorkers) {
        return repairShopWorkerRepository.save(repairShopWorkers);
    }

}