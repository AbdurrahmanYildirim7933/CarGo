package com.mantis.mapper;

import com.mantis.data.dto.RepairShopWorkersDTO;
import com.mantis.data.entity.RepairShopWorkers;

public class RepairShopWorkersMapper {

    public RepairShopWorkersDTO toDTO(RepairShopWorkers repairShopWorkers){

        RepairShopWorkersDTO repairShopWorkersDTO = new RepairShopWorkersDTO();
        repairShopWorkersDTO.setId(repairShopWorkers.getId());
        repairShopWorkersDTO.setAddress(repairShopWorkers.getAddress());
        repairShopWorkersDTO.setName(repairShopWorkers.getName());
        repairShopWorkersDTO.setPhone(repairShopWorkers.getPhone());
        repairShopWorkersDTO.setIdentityNumber(repairShopWorkers.getIdentityNumber());
        repairShopWorkersDTO.setLastName(repairShopWorkers.getLastName());

        return repairShopWorkersDTO;
    }

    public RepairShopWorkers toEntity(RepairShopWorkersDTO repairShopWorkersDTO){

        RepairShopWorkers repairShopWorkers = new RepairShopWorkers();
        repairShopWorkers.setId(repairShopWorkersDTO.getId());
        repairShopWorkers.setAddress(repairShopWorkersDTO.getAddress());
        repairShopWorkers.setName(repairShopWorkersDTO.getName());
        repairShopWorkers.setPhone(repairShopWorkersDTO.getPhone());
        repairShopWorkers.setIdentityNumber(repairShopWorkersDTO.getIdentityNumber());
        repairShopWorkers.setLastName(repairShopWorkersDTO.getLastName());

        return repairShopWorkers;
    }

}
