package com.mantis.mapper;


import com.mantis.data.dto.RepairShopDutyDTO;
import com.mantis.data.entity.RepairShopDutyRelation;
import org.springframework.stereotype.Component;


@Component
public class RepairShopDutyMapper {

    public RepairShopDutyDTO toDTO(RepairShopDutyRelation repairShopDuty){
        RepairShopDutyDTO _repairShopDutyDTO= new RepairShopDutyDTO();
        _repairShopDutyDTO.setId(repairShopDuty.getId());
        _repairShopDutyDTO.setPrice(repairShopDuty.getPrice());
        RepairShopMapper repairShopMapper = new RepairShopMapper();
        _repairShopDutyDTO.setRepairShopDTO(repairShopMapper.toDTO(repairShopDuty.getRepairShop()));
        DutyMapper dutyMapper = new DutyMapper();
        _repairShopDutyDTO.setDutyDTO(dutyMapper.toDTO(repairShopDuty.getDuty()));


        return _repairShopDutyDTO;
    }

    public RepairShopDutyRelation toEntity(RepairShopDutyDTO repairShopDutyDTO){
        RepairShopDutyRelation _repairShopDutyRelation= new RepairShopDutyRelation();
        _repairShopDutyRelation.setId(repairShopDutyDTO.getId());
        _repairShopDutyRelation.setPrice(repairShopDutyDTO.getPrice());
        DutyMapper dutyMapper = new DutyMapper();
        _repairShopDutyRelation.setDuty(dutyMapper.toEntity(repairShopDutyDTO.getDutyDTO()));
        RepairShopMapper repairShopMapper =new RepairShopMapper();
        _repairShopDutyRelation.setRepairShop(repairShopMapper.toEntity(repairShopDutyDTO.getRepairShopDTO()));


        return _repairShopDutyRelation;
    }
}


