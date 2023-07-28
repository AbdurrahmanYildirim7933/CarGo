package com.mantis.mapper;

import com.mantis.data.dto.EmployeeDTO;
import com.mantis.data.entity.Employee;

public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee)
    {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setName(employee.getName());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());

        return employeeDTO;
    }

    public Employee toEntity(EmployeeDTO employeeDTO)
    {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setAddress(employeeDTO.getAddress());
        employee.setName(employeeDTO.getName());
        employee.setPhone(employeeDTO.getPhone());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());

        return employee;
    }

}
