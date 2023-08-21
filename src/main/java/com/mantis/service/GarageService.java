package com.mantis.service;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.entity.Garage;
import com.mantis.logic.GarageLogic;
import com.mantis.mapper.GarageMapper;
import com.mantis.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class GarageService {

    @Autowired
    GarageLogic garageLogic;

    @Autowired
    UserService userService;

    GarageMapper garageMapper = new GarageMapper();
    UserMapper userMapper = new UserMapper();

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
    @PreAuthorize("hasAuthority('GET_GARAGES_BY_USER')")
    public Page<GarageDTO> getGaragesByUserId(Pageable pageable){
        List <GarageDTO> dtoList = garageMapper.toListDTO(garageLogic.getGaragesByUserID(pageable));
        Page <GarageDTO> dtoPages = new PageImpl<>(dtoList);
        return dtoPages;
    }




}
