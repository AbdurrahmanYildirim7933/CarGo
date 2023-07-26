package com.mantis.mapper;

import com.mantis.data.dto.RepairShopDTO;
import com.mantis.data.entity.RepairShop;

public class RepairShopMapper {


    public RepairShopDTO toDTO(RepairShop repairShop){
        RepairShopDTO _repairShop= new RepairShopDTO();
        _repairShop.setId(repairShop.getId());
        _repairShop.setName(repairShop.getName());
        _repairShop.setAddress(repairShop.getAddress());
        _repairShop.setRepairShopDutyRelations(repairShop.getRepairShopDutyRelations());


        return _repairShop;
    }
    public RepairShop toEntity(RepairShopDTO repairShopDTO){
        RepairShop _repairShop= new RepairShop();
        _repairShop.setId(repairShopDTO.getId());
        _repairShop.setName(repairShopDTO.getName());
        _repairShop.setAddress(repairShopDTO.getAddress());
        _repairShop.setRepairShopDutyRelations(repairShopDTO.getRepairShopDutyRelations());


        return _repairShop;
    }

}