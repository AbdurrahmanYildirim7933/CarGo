package com.mantis.mapper;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.entity.Garage;

public class GarageMapper {

    UserMapper userMapper = new UserMapper();

    public GarageDTO toDTO(Garage garage){
        GarageDTO _garage= new GarageDTO();
        _garage.setId(garage.getId());
        _garage.setName(garage.getName());
        _garage.setOwner(userMapper.toDTO(garage.getOwner()));
        return _garage;
    }

    public Garage toEntity(GarageDTO garageDTO){
        Garage _garage= new Garage();
        _garage.setId(garageDTO.getId());
        _garage.setName(garageDTO.getName());
        _garage.setOwner(userMapper.toEntity(garageDTO.getOwner()));
        return _garage;
    }



}
