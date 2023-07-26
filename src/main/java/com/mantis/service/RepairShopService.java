
package com.mantis.service;

import com.mantis.data.dto.RepairShopDTO;
import com.mantis.data.dto.RepairShopDutyDTO;
import com.mantis.logic.RepairShopLogic;
import com.mantis.mapper.RepairShopDutyMapper;
import com.mantis.mapper.RepairShopMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasAuthority;

@Service
@Transactional
public class RepairShopService {

    @Autowired
    private RepairShopLogic repairShopLogic;

    private RepairShopMapper repairShopMapper= new RepairShopMapper();

    RepairShopDutyMapper repairShopDutyMapper= new RepairShopDutyMapper();

    @PreAuthorize("hasAuthority('CREATE_REPAIR_SHOP')")
    public RepairShopDTO createService(RepairShopDTO repairShopDTO) {
        return  this.repairShopMapper.toDTO(repairShopLogic.createService(repairShopMapper.toEntity(repairShopDTO))) ;
    }

    @PreAuthorize("hasAuthority('CREATE_REPAIR_SHOP_DUTY')")
    public RepairShopDutyDTO createRepairShopDuty(RepairShopDutyDTO repairShopDutyDTO) {
        return  this.repairShopDutyMapper.toDTO(repairShopLogic.createRepairShopDuty(repairShopDutyMapper.toEntity(repairShopDutyDTO))) ;
    }
}