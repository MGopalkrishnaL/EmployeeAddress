package com.Geekster.EmployeeAddress.service;

import com.Geekster.EmployeeAddress.model.Employee;
import com.Geekster.EmployeeAddress.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeRepository employeRepository;
    public ResponseEntity<List<Employee>> getAllEmploye() {
        List<Employee> employeeList = employeRepository.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    public ResponseEntity<Employee> getEmployeById(long employeeId) {
        Employee employee = employeRepository.findById(employeeId).get();
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    public ResponseEntity<String> saveEmployee(Employee employee) {
        employeRepository.save(employee);
        return new ResponseEntity<>("Employee has been saved",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> updateEmployeeById(long employeId, Employee employee) {
        if(employeRepository.existsById(employeId)){
            Employee employee1 = employeRepository.findById(employeId).get();
            employee1.setAddress(employee.getAddress());
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employeRepository.save(employee1);
            return new ResponseEntity<>("employe has been updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("employee has not been found",HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> deleteEmployeById(long id) {
        if(employeRepository.existsById(id)){
            employeRepository.deleteById(id);
            return new ResponseEntity<>("employee has been deleted successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("employe has not been found",HttpStatus.NOT_FOUND);
    }
}
