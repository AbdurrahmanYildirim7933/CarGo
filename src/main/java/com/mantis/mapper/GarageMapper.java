package com.mantis.mapper;

import com.github.fge.jsonpatch.JsonPatch;
import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.ShopDTO;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.Garage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GarageMapper {
    UserMapper userMapper = new UserMapper();
    public GarageDTO toDTO(Garage garage){
        GarageDTO _garage= new GarageDTO();
        _garage.setId(garage.getId());
        _garage.setName(garage.getName());
        _garage.setOwner(userMapper.toDTO(garage.getOwner()));
        return _garage;}
    public Garage toEntity(GarageDTO garageDTO){
        Garage _garage= new Garage();
        _garage.setId(garageDTO.getId());
        _garage.setName(garageDTO.getName());
        if(garageDTO.getOwner()!=null){
            _garage.setOwner(userMapper.toEntity(garageDTO.getOwner()));
        }
        return _garage;
    }

    public List<GarageDTO> toListDTO(Page<Garage> garageEntities){

        return garageEntities.stream().map(g->toDTO(g)).collect(Collectors.toList());
    }
    public List<Garage> toListEntity(Page<GarageDTO> garageDTOS){

        return garageDTOS.stream().map(g->toEntity(g)).collect(Collectors.toList());
    }

}
