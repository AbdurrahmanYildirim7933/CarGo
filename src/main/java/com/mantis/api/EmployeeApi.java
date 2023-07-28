package com.mantis.api;

import com.mantis.data.dto.EmployeeDTO;
import com.mantis.data.dto.GarageDTO;
import com.mantis.service.EmployeeService;
import com.mantis.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeApi {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create-employee")
    public ResponseEntity<EmployeeDTO> createGarage(@RequestBody EmployeeDTO employeeDTO)
    {
        EmployeeDTO createdEmployeeDTO = employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok(createdEmployeeDTO);
    }

}
