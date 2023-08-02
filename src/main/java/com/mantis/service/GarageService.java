package com.mantis.service;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.entity.Garage;
import com.mantis.logic.GarageLogic;
import com.mantis.mapper.GarageMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GarageService {

    @Autowired
    GarageLogic garageLogic;

    GarageMapper garageMapper = new GarageMapper();

    private List<GarageDTO> garageDTOS = new ArrayList<>();

    @PreAuthorize("hasAuthority('CREATE_GARAGE')")
    public GarageDTO createGarage(GarageDTO garageDTO) {
        return  garageMapper.toDTO(garageLogic.createGarage(garageMapper.toEntity(garageDTO)));
    }

    @PreAuthorize("hasAuthority('GET_GARAGE')")
    public GarageDTO getGarage(Integer id){
        return garageMapper.toDTO(garageLogic.getGarage(id));
    }

    @PreAuthorize("hasAuthority('DELETE_GARAGE')")
    public void deleteGarage(Integer id){
        garageLogic.deleteGarage(id);
    }

    @PreAuthorize("hasAuthority('UPDATE_GARAGE')")
    public GarageDTO updateGarage(Integer id,GarageDTO garageDTO){
        return garageMapper.toDTO(garageLogic.updateGarage(id,garageMapper.toEntity(garageDTO)));
    }

}
