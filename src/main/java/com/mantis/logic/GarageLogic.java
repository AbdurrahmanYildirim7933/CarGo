package com.mantis.logic;

import com.mantis.data.dto.GarageDTO;
import com.mantis.data.dto.SessionDTO;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.User;
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
    UserRepository userRepository;

    @Autowired
    AuthorizationLogic authorizationLogic;


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

    public Garage updateGarage(Integer id, Garage newGarage){
        Garage oldGarage = garageRepository.findById(id).orElseThrow(()-> new RuntimeException("Garage cannot found"));
                oldGarage.setName(newGarage.getName());
                oldGarage.setCars(newGarage.getCars());
                garageRepository.save(oldGarage);
          return oldGarage;
    }

    public Page<Garage> getGaragesByUserID(Pageable pageable) {
        if (ObjectUtils.isEmpty(authorizationLogic.getSession().getId())) {
            throw new RuntimeException("ID cannot be null");
        }
        Page<Garage> garages = garageRepository.getGaragesByUserId(authorizationLogic.getSession().getId(),pageable);
        if(ObjectUtils.isEmpty(garages)){
            throw new RuntimeException("U dont have a garage right know please buy a garage for urself...");
        }
        return garages;
    }


}
