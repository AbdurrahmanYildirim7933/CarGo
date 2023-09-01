package com.mantis.logic;

import com.mantis.data.dto.SessionDTO;
import com.mantis.data.entity.*;
import com.mantis.repositories.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
public class CarLogic {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ModelRepository modelRepository;
    @Autowired
    CarImageRepository carImageRepository;
    @Autowired
    GarageRepository garageRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorizationLogic authorizationLogic;


    public Car createCar(Car car,Integer garageId)
    {
        SessionDTO session;
        session = authorizationLogic.getSession();
        Optional<Garage> optionalGarage = garageRepository.findById(garageId);
        if (optionalGarage.isPresent()) {
            Garage garage = optionalGarage.get();
            car.setGarage(garage);
            return carRepository.save(car);
        }
        throw new RuntimeException("Hata garaj bulunamadı");
    }
    public Car getCar(Integer id){
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car cannot found"));
    }
    public void deleteGarage(Integer id){
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }
        carRepository.deleteById(id);
    }
    public Car updateCar(Integer id, Car newCar){
        Car oldCar = carRepository.findById(id).orElseThrow(()-> new RuntimeException("Garage cannot found"));
        oldCar.setBrand(newCar.getBrand());
        oldCar.setLicensePlate(newCar.getLicensePlate());
        oldCar.setYear(newCar.getYear());
        oldCar.setModel(newCar.getModel());
        carRepository.save(oldCar);
        return oldCar;
    }
    public Page<Car> getCarsByGarageId(Integer id,Pageable pageable) {
        if (ObjectUtils.isEmpty(authorizationLogic.getSession())){
            throw new RuntimeException("User cannot be found");
        }
        Page<Car> cars = carRepository.getCarsByGarageId(id,pageable);
        if(ObjectUtils.isEmpty(cars)){
            throw new RuntimeException("Garage is empty right now,There are currently no cars in your garage");
        }
        return cars;
    }

    public CarImage uploadImage(CarImage carImage,Integer carId) throws IOException {
        Optional<Car> optionalCar = carRepository.findById(carId);
        byte[] fileContent = FileUtils.readFileToByteArray(new File(carImage.getFileContentBase64()));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            carImage.setCar(car);
        }
        return carImageRepository.save(carImage);
    }

    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

    public List<Model> getModelsByBrand(Integer brandId){
        return modelRepository.getModelsByBrand(brandId);
    }
}
