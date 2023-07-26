
package com.mantis.logic;


import com.mantis.data.entity.Duty;
import com.mantis.repositories.DutyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DutyLogic {
    @Autowired
    DutyRepository dutyRepository;

    public Duty createPermission(Duty duty) {

        return dutyRepository.save(duty);
    }
}