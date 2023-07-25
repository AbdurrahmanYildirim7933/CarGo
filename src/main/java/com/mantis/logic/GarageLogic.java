package com.mantis.logic;

import com.mantis.data.entity.Garage;
import com.mantis.data.entity.User;
import com.mantis.repositories.GarageRepository;
import com.mantis.repositories.PermissionRepository;
import com.mantis.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GarageLogic {

    //owner
    //  id
    //findbyid

    @Autowired
    GarageRepository garageRepository;
    @Autowired
    UserRepository userRepository;

    public Garage createGarage(Garage garage)
    {

        if(garage.getOwner() != null) {
            if(garage.getOwner().getId() != null)
            {
                if(userRepository.existsById(garage.getOwner().getId())) {
                    User user = userRepository.findById(garage.getOwner().getId()).orElseThrow();
                    garage.setOwner(user);
                    return garageRepository.save(garage);
                }
            }
        }
        return null;
    }

}
