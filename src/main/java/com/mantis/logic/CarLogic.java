package com.mantis.logic;

import com.mantis.data.entity.*;
import com.mantis.repositories.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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


    public Car createCar(Car car, Integer garageId) {
        Optional<Garage> optionalGarage = garageRepository.findById(garageId);
        if (optionalGarage.isPresent()) {
            Garage garage = optionalGarage.get();
            car.setGarage(garage);
            return carRepository.save(car);
        }
        throw new RuntimeException("Hata garaj bulunamadı");
    }

    public Car getCar(Integer id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car cannot found"));
    }

    public void deleteCar(Integer id) {
        List<CarImage> carImageList = carImageRepository.getImagesByCar(id);
        carImageRepository.deleteAll(carImageList);
        carRepository.deleteById(id);
    }

    public Car updateCar(Integer id, Car newCar) {
        Car oldCar = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Garage cannot found"));
        oldCar.setBrand(newCar.getBrand());
        oldCar.setLicensePlate(newCar.getLicensePlate().toUpperCase());
        oldCar.setYear(newCar.getYear());
        oldCar.setModel(newCar.getModel());
        carRepository.save(oldCar);
        return oldCar;
    }

    public Page<Car> getCarsByGarageId(Integer id, Pageable pageable) {
        if (ObjectUtils.isEmpty(authorizationLogic.getSession())) {
            throw new RuntimeException("User cannot be found");
        }
        Page<Car> cars = carRepository.getCarsByGarageId(id, pageable);
        if (ObjectUtils.isEmpty(cars)) {
            throw new RuntimeException("Garage is empty right now,There are currently no cars in your garage");
        }
        return cars;
    }

    public List<CarImage> uploadImage(List<CarImage> carImageList, Integer carId) throws IOException {
        Optional<Car> optionalCar = carRepository.findById(carId);
        CarImage img = new CarImage();
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            carImageList.stream().forEach(c -> c.setCar(car));
        }
        return carImageRepository.saveAll(carImageList);
    }

    public void deleteImages(List<Integer> carImagesIds) {
        carImageRepository.deleteAllById(carImagesIds);
    }

    public List<CarImage> getImagesByCar(Integer id) {

        final List<CarImage> retrievedImages = carImageRepository.getImagesByCar(id);
        retrievedImages.stream().forEach(r -> new CarImage(r.getName(), r.getType(), r.getFilebase64()));
        return retrievedImages;

    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public List<Model> getModelsByBrand(Integer brandId) {
        return modelRepository.getModelsByBrand(brandId);
    }

    public Brand getBrand(Integer id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isPresent()) {
            Brand brand = optionalBrand.get();
            return brand;
        }
        return null;
    }

    public Model getModel(Integer id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        if (optionalModel.isPresent()) {
            Model model = optionalModel.get();
            return model;
        }
        return null;
    }

}
