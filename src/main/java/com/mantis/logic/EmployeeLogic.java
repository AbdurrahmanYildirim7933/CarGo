package com.mantis.logic;
import com.mantis.data.entity.Employee;
import com.mantis.data.entity.Garage;
import com.mantis.data.entity.User;
import com.mantis.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLogic {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee)
    {
                return employeeRepository.save(employee);
    }


}
