package com.mantis.logic;

import com.mantis.data.entity.Garage;
import com.mantis.data.entity.User;
import com.mantis.repositories.GarageRepository;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GarageLogic {

    @Autowired
    GarageRepository garageRepository;
    @Autowired
    UserRepository userRepository;

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

}
