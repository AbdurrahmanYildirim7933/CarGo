package com.mantis.mapper;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.GarageFilterDTO;
import com.mantis.data.entity.Garage;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class GarageFilterMapper {

    UserMapper userMapper = new UserMapper();
    public GarageFilterDTO toDTO(Garage garage){
        GarageFilterDTO _garage= new GarageFilterDTO();
        _garage.setId(garage.getId());
        _garage.setName(garage.getName());
        _garage.setOwner(userMapper.toDTO(garage.getOwner()));
        return _garage;}
    public Garage toEntity(GarageFilterDTO garageDTO){
        Garage _garage= new Garage();
        _garage.setId(garageDTO.getId());
        _garage.setName(garageDTO.getName());
        if(garageDTO.getOwner()!=null){
            _garage.setOwner(userMapper.toEntity(garageDTO.getOwner()));
        }
        return _garage;
    }
    /*public List<Car> toListCarDTO(Page<Car> carEntities){

        return carEntities.stream().map(g->toDTO(g)).collect(Collectors.toList());
    }

    public List<Car> toListCarEntity(Page<Car> carDTOS){

        return carDTOS.stream().map(g->toEntity(g)).collect(Collectors.toList());
    }*/

    public List<GarageFilterDTO> toListDTO(Page<Garage> garageEntities){

        return garageEntities.stream().map(g->toDTO(g)).collect(Collectors.toList());
    }
    public List<Garage> toListEntity(Page<GarageFilterDTO> garageDTOS){

        return garageDTOS.stream().map(g->toEntity(g)).collect(Collectors.toList());
    }

}
