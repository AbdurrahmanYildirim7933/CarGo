package com.mantis.service;
import com.mantis.data.dto.DutyDTO;
import com.mantis.logic.DutyLogic;
import com.mantis.mapper.DutyMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class    DutyService {
    @Autowired
    DutyLogic dutyLogic;

    DutyMapper dutyMapper = new DutyMapper();

    @PreAuthorize("hasAuthority('CREATE_DUTY')")
    public DutyDTO createDuty(DutyDTO dutyDTO) {
        return  dutyMapper.toDTO(dutyLogic.createPermission(dutyMapper.toEntity(dutyDTO)));
    }
}