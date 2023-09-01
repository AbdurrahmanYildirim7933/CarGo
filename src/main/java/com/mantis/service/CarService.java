package com.mantis.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatchException;
import com.mantis.data.dto.*;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.CarImage;
import com.mantis.logic.CarFilterLogic;
import com.mantis.logic.CarLogic;
import com.mantis.mapper.BrandMapper;
import com.mantis.mapper.CarMapper;
import com.mantis.mapper.ModelMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class CarService {
    @Autowired
    CarLogic carLogic;
    @Autowired
    CarFilterLogic carFilterLogic;
    CarMapper carMapper = new CarMapper();
    BrandMapper brandMapper = new BrandMapper();
    ModelMapper modelMapper = new ModelMapper();
    public CarDTO createCar(Integer id,CarDTO carDTO) {
        return  carMapper.toDTO(carLogic.createCar(carMapper.toEntity(carDTO),id));
    }
    public CarDTO getGarage(Integer id){
        return carMapper.toDTO(carLogic.getCar(id));
    }
    public void deleteGarage(Integer id){
        carLogic.deleteGarage(id);
    }
    public CarDTO updateCar(Integer id, CarDTO carDTO) throws JsonPatchException, JsonProcessingException {
        return carMapper.toDTO(carLogic.updateCar(id,carMapper.toEntity(carDTO)));
    }
    public CarImageDTO uploadImage(CarImageDTO carImageDTO, Integer carId) throws IOException {
        return  carMapper.imageToDTO(carLogic.uploadImage(carMapper.imageToEntity(carImageDTO),carId));
    }
    public QueryModel getCarsByGarageId(CarFilterDTO carFilterDTO,Integer id, Pageable pageable){
        Page<CarDTO> carDTOPage = new PageImpl<>(carMapper.toListDTO(carFilterLogic.searchGarageByTerm(carFilterDTO,id,pageable)));
        List< CarDTO> dtoCarList = carDTOPage.getContent();
        QueryModel queryModel = new QueryModel();
        queryModel.setCars(dtoCarList);
        queryModel.setPages(carFilterLogic.searchGarageByTerm(carFilterDTO,id,pageable).getTotalPages());
        queryModel.setCount(carFilterLogic.searchGarageByTerm(carFilterDTO,id,pageable).getTotalElements());
     return  queryModel;
    }
    public CarDTO getCar(Integer id){
        return carMapper.toDTO(carLogic.getCar(id));
    }

    public List<BrandDTO> getBrands(){
        return brandMapper.toListDTO(carLogic.getAllBrands());
    }

    public List<ModelDTO> getModelsByBrand(Integer brandId){
        return modelMapper.toListDTO(carLogic.getModelsByBrand(brandId));
    }
}

