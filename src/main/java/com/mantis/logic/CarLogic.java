package com.mantis.logic;

import com.mantis.data.dto.SessionDTO;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.User;
import com.mantis.repositories.CarRepository;
import com.mantis.repositories.GarageRepository;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Component
public class CarLogic {

    @Autowired
    CarRepository carRepository;
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
    public Car updateGarage(Integer id, Car newCar){
        Car oldCar = carRepository.findById(id).orElseThrow(()-> new RuntimeException("Garage cannot found"));
        oldCar.setBrand(newCar.getBrand());
        oldCar.setLicensePlate(newCar.getLicensePlate());
        oldCar.setYear(newCar.getYear());
        oldCar.setModel(newCar.getModel());
        oldCar.setGarage(newCar.getGarage());
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

}
