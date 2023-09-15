package com.mantis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.mantis.data.dto.*;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.Garage;
import com.mantis.logic.GarageFilterLogic;
import com.mantis.logic.GarageLogic;
import com.mantis.mapper.CarMapper;
import com.mantis.mapper.GarageFilterMapper;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class GarageService {

    @Autowired
    GarageLogic garageLogic;

    @Autowired
    UserService userService;
    @Autowired
    GarageFilterLogic garageFilterLogic;

    CarMapper carMapper = new CarMapper();
    GarageMapper garageMapper = new GarageMapper();
    GarageFilterMapper garageFilterMapper = new GarageFilterMapper();
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
    public GarageDTO updateGarage(Integer id, GarageDTO garageDTO) throws JsonPatchException, JsonProcessingException {
        return garageMapper.toDTO(garageLogic.updateGarage(id,garageMapper.toEntity(garageDTO)));
    }
    @PreAuthorize("hasAuthority('GET_GARAGES_BY_USER')")
    public QueryModel getGaragesByUserId(GarageFilterDTO garageFilterDTO,Pageable pageable){
        Page<GarageDTO> pageGarage = new PageImpl<>(garageMapper.toListDTO(garageFilterLogic.searchGarageByTerm(garageFilterDTO,pageable)));
        List<GarageDTO> listGarage = pageGarage.getContent();
        QueryModel queryModel = new QueryModel();
        queryModel.setGarages(listGarage);
        queryModel.setCount( garageFilterLogic.searchGarageByTerm(garageFilterDTO,pageable).getTotalElements());
        queryModel.setPages( garageFilterLogic.searchGarageByTerm(garageFilterDTO,pageable).getTotalPages());
        return queryModel;
    }

    public List<GarageDTO> getGarages() {
        return garageMapper.dtoList(garageLogic.getGarages());
    }
}
