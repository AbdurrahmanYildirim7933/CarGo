package com.mantis.service;

import com.mantis.data.dto.EmployeeDTO;
import com.mantis.data.dto.GarageDTO;
import com.mantis.logic.EmployeeLogic;
import com.mantis.logic.GarageLogic;
import com.mantis.mapper.EmployeeMapper;
import com.mantis.mapper.GarageMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployeeService {

        @Autowired
        EmployeeLogic employeeLogic;

        EmployeeMapper employeeMapper = new EmployeeMapper();

        @PreAuthorize("hasAuthority('CREATE_EMPLOYEE')")
        public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
            return  employeeMapper.toDTO(employeeLogic.createEmployee(employeeMapper.toEntity(employeeDTO)));
        }

}


