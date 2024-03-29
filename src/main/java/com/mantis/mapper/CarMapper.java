package com.mantis.mapper;

import com.mantis.data.dto.CarDTO;
import com.mantis.data.dto.CarImageDTO;
import com.mantis.data.dto.GarageDTO;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.CarImage;
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
        if (car.getBrand() != null) {
            _car.setBrand(brandMapper.toDTO(car.getBrand()));
        }
        if (car.getGarage() != null) {
            _car.setGarage(garageMapper.toDTO(car.getGarage()));
        }
        _car.setLicensePlate(car.getLicensePlate());
        if(car.getModel()!= null) {
            _car.setModel(modelMapper.toDTO(car.getModel()));
        }
        _car.setYear(car.getYear());

        return _car;}
    public Car toEntity(CarDTO carDTO){

        Car _car = new Car();
        _car.setId(carDTO.getId());
        if (carDTO.getBrand() != null) {
            _car.setBrand(brandMapper.toEntity(carDTO.getBrand()));
        }
        if (carDTO.getGarage() != null) {
            _car.setGarage(garageMapper.toEntity(carDTO.getGarage()));
        }
        _car.setLicensePlate(carDTO.getLicensePlate());
        if(carDTO.getModel()!= null) {
            _car.setModel(modelMapper.toEntity(carDTO.getModel()));
        }
        _car.setYear(carDTO.getYear());
        return _car;
    }

    public List<CarDTO> toListDTO(Page<Car> carEntities){

        return carEntities.stream().map(g->toDTO(g)).collect(Collectors.toList());
    }
    public List<Car> toListEntity(Page<CarDTO> carDTOS){

        return carDTOS.stream().map(g->toEntity(g)).collect(Collectors.toList());
    }

    public CarImage imageToEntity(CarImageDTO carImageDTO){

        CarImage _car = new CarImage();
        _car.setId(carImageDTO.getId());
        _car.setName(carImageDTO.getName());
        _car.setFilebase64(carImageDTO.getFilebase64());
        _car.setType(carImageDTO.getType());
        if(carImageDTO.getCar()!= null) {
            _car.setCar(toEntity(carImageDTO.getCar()));
        }
        return _car;
    }

    public CarImageDTO imageToDTO(CarImage carImage){

        CarImageDTO _car = new CarImageDTO();
        _car.setId(carImage.getId());
        _car.setName(carImage.getName());
        _car.setFilebase64(carImage.getFilebase64());
        _car.setType(carImage.getType());
        if(carImage.getCar()!=null) {
            _car.setCar(toDTO(carImage.getCar()));
        }
        return _car;
    }

    public List<CarImageDTO> imagesToListDTO(List<CarImage> carImageEntities){

        return carImageEntities.stream().map(i->imageToDTO(i)).collect(Collectors.toList());
    }
    public List<CarImage> imagesToListEntity(List<CarImageDTO> carImageDTOS){

        return carImageDTOS.stream().map(i->imageToEntity(i)).collect(Collectors.toList());
    }
}
