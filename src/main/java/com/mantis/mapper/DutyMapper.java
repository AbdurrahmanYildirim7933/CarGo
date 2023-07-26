package com.mantis.mapper;

import com.mantis.data.dto.DutyDTO;
import com.mantis.data.entity.Duty;

public class DutyMapper {
    public DutyDTO toDTO(Duty duty){
        DutyDTO _duty= new DutyDTO();
        _duty.setId(duty.getId());
        _duty.setName(duty.getName());
        _duty.setRepairShopDutyRelation(duty.getRepairShopDutyRelations());

        return _duty;
    }

    public Duty toEntity(DutyDTO dutyDTO){
        Duty _duty= new Duty();
        _duty.setId(dutyDTO.getId());
        _duty.setName(dutyDTO.getName());
        _duty.setRepairShopDutyRelations(dutyDTO.getRepairShopDutyRelation());

        return _duty;
    }
}