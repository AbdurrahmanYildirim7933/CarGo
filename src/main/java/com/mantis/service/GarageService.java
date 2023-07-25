package com.mantis.service;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.PermissionDTO;
import com.mantis.logic.GarageLogic;
import com.mantis.logic.PermissionLogic;
import com.mantis.mapper.GarageMapper;
import com.mantis.mapper.PermissionMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GarageService {

    @Autowired
    GarageLogic garageLogic;

    GarageMapper garageMapper = new GarageMapper();

    @PreAuthorize("hasAuthority('CREATE_GARAGE')")
    public GarageDTO createGarage(GarageDTO GarageDTO) {
        return  garageMapper.toDTO(garageLogic.createGarage(garageMapper.toEntity(GarageDTO)));
    }

}
