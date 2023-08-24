package com.mantis.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.GarageFilterDTO;
import com.mantis.data.dto.SessionDTO;
import com.mantis.data.entity.Car;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.Shop;
import com.mantis.data.entity.User;
import com.mantis.repositories.CarRepository;
import com.mantis.repositories.GarageRepository;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class   GarageLogic {

    @Autowired
    GarageRepository garageRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorizationLogic authorizationLogic;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    GarageFilterLogic garageFilterLogic;

    public Garage createGarage(Garage garage)
    {
        SessionDTO session;
        session = authorizationLogic.getSession();
        User user = userRepository.findById(session.getId()).orElse(null);
        garage.setOwner(user);
        return garageRepository.save(garage);

    }

    public Garage getGarage(Integer id){
    return garageRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Garage cannot found"));
    }

    public void deleteGarage(Integer id){
        if (id == null || id == 0) {
            throw new RuntimeException("ID cannot be null");
        }
        garageRepository.deleteById(id);
    }
    public Garage updateGarage(Integer id, Garage garage) throws JsonPatchException, JsonProcessingException {
        Garage oldGarage = garageRepository.findById(id).orElseThrow(()-> new RuntimeException("Garage cannot found"));
        oldGarage.setName(garage.getName());
        oldGarage.setCars(garage.getCars());
        garageRepository.save(oldGarage);
        return oldGarage;
    }
    public Page<Garage> getGaragesByUserID(GarageFilterDTO garageFilterDTO,Pageable pageable) {
        if (ObjectUtils.isEmpty(authorizationLogic.getSession().getId())) {
            throw new RuntimeException("ID cannot be null");
        }
        Page<Garage> garages = garageFilterLogic.searchGarageByTerm(garageFilterDTO,pageable);
        if(ObjectUtils.isEmpty(garages)){
            throw new RuntimeException("U dont have a garage right know please buy a garage for urself...");
        }
        return garages;
    }
    public Page<Car> getCarsByGarageId(Integer id,Pageable pageable) {
        if (ObjectUtils.isEmpty(id)) {
            throw new RuntimeException("Garage id cannot be null");
        }
        Page<Car> cars = carRepository.getCarsByGarageId(id,pageable);
        if(ObjectUtils.isEmpty(cars)){
            throw new RuntimeException("Garage is empty right know,u can buy a car");
        }
        return cars;
    }
    public List<Shop> findByName(String name) {

        return garageRepository.findShopByName(name);
    }
    public List<Shop> searchShopByTerm(Garage garage){
        return null;
    }
}
