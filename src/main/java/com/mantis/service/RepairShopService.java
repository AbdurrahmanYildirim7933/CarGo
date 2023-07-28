
package com.mantis.service;

import com.mantis.data.dto.RepairShopDTO;
import com.mantis.data.dto.RepairShopDutyDTO;
import com.mantis.data.dto.RepairShopWorkersDTO;
import com.mantis.data.entity.RepairShop;
import com.mantis.logic.RepairShopLogic;
import com.mantis.mapper.RepairShopDutyMapper;
import com.mantis.mapper.RepairShopMapper;
import com.mantis.mapper.RepairShopWorkersMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RepairShopService {

    @Autowired
    private RepairShopLogic repairShopLogic;

    private RepairShopMapper repairShopMapper= new RepairShopMapper();

    private RepairShopWorkersMapper repairShopWorkersMapper = new RepairShopWorkersMapper();

    private RepairShopDutyMapper repairShopDutyMapper= new RepairShopDutyMapper();

    @PreAuthorize("hasAuthority('CREATE_REPAIR_SHOP')")
    public RepairShopDTO createService(RepairShopDTO repairShopDTO) {
        return  this.repairShopMapper.toDTO(repairShopLogic.createService(repairShopMapper.toEntity(repairShopDTO))) ;
    }

    @PreAuthorize("hasAuthority('CREATE_REPAIR_SHOP_DUTY')")
    public RepairShopDutyDTO createRepairShopDuty(RepairShopDutyDTO repairShopDutyDTO) {
        return  this.repairShopDutyMapper.toDTO(repairShopLogic.createRepairShopDuty(repairShopDutyMapper.toEntity(repairShopDutyDTO))) ;
    }

    @PreAuthorize("hasAuthority('CREATE_REPAIR_SHOP_WORKERS')")
    public RepairShopWorkersDTO createRepairShopWorkers(RepairShopWorkersDTO repairShopWorkersDTO) {
        return  this.repairShopWorkersMapper.toDTO(repairShopLogic.createRepairShopWorkers(repairShopWorkersMapper.toEntity(repairShopWorkersDTO))) ;
    }
}