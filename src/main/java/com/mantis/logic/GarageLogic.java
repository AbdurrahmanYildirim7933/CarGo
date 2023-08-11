package com.mantis.logic;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.User;
import com.mantis.repositories.GarageRepository;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class        GarageLogic {

    @Autowired
    GarageRepository garageRepository;
    @Autowired
    UserRepository userRepository;

    private List<Garage> garages = new ArrayList<>();

    public Garage createGarage(Garage garage)
    {

        if(garage.getOwner() != null && garage.getOwner().getId() != null) {
                User user = userRepository.findById(garage.getOwner().getId()).orElse(null);
                if(user != null) {
                    garage.setOwner(user);
                    return garageRepository.save(garage);
                }
        }
        return null;
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

    public Garage updateGarage(Integer id, Garage newGarage){
        Garage oldGarage = garageRepository.findById(id).orElseThrow(()-> new RuntimeException("Garage cannot found"));
        if(newGarage.getOwner() != null && newGarage.getOwner().getId() != null) {
            User user = userRepository.findById(newGarage.getOwner().getId()).orElse(null);
            if (user != null) {
                oldGarage.setName(newGarage.getName());
                oldGarage.setCars(newGarage.getCars());
                oldGarage.setOwner(user);
                garageRepository.save(oldGarage);
            }
        }  return oldGarage;
    }

    public List<Garage> getGaragesByUserID(Integer user_id) {
        if (ObjectUtils.isEmpty(user_id)) {
            throw new RuntimeException("ID cannot be null");
        } List<Garage> garages = garageRepository.getGaragesByUserId(user_id);
        if(ObjectUtils.isEmpty(garages)){
            throw new RuntimeException("Garage is empty right now");
        }
        return garages;
    }


}
