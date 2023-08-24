package com.mantis.mapper;

import com.mantis.data.dto.CarDTO;
import com.mantis.data.dto.GarageDTO;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.Garage;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


public class CarMapper {
    GarageMapper garageMapper = new GarageMapper();
    BrandMapper brandMapper = new BrandMapper();
    ModelMapper modelMapper = new ModelMapper();
    public CarDTO toDTO(Car car){

        CarDTO _car = new CarDTO();
        _car.setId(car.getId());
        _car.setBrand(brandMapper.toDTO(car.getBrand()));
        _car.setGarage(garageMapper.toDTO(car.getGarage()));
        _car.setLicensePlate(car.getLicensePlate());
        _car.setModel(modelMapper.toDTO(car.getModel()));
        _car.setYear(car.getYear());

        return _car;}
    public Car toEntity(CarDTO carDTO){

        Car _car = new Car();
        _car.setId(carDTO.getId());
        _car.setBrand(brandMapper.toEntity(carDTO.getBrand()));
        _car.setGarage(garageMapper.toEntity(carDTO.getGarage()));
        _car.setLicensePlate(carDTO.getLicensePlate());
        _car.setModel(modelMapper.toEntity(carDTO.getModel()));
        _car.setYear(carDTO.getYear());
        return _car;
    }

    public List<CarDTO> toListDTO(Page<Car> carEntities){

        return carEntities.stream().map(g->toDTO(g)).collect(Collectors.toList());
    }
    public List<Car> toListEntity(Page<CarDTO> carDTOS){

        return carDTOS.stream().map(g->toEntity(g)).collect(Collectors.toList());
    }
}
