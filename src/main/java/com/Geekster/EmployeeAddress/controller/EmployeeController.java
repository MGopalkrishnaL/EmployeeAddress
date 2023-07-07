package com.Geekster.EmployeeAddress.controller;

import com.Geekster.EmployeeAddress.model.Employee;
import com.Geekster.EmployeeAddress.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    @GetMapping("get_all_employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return employeeService.getAllEmploye();
    }
    @GetMapping("get_employee_by_id")
    public ResponseEntity<Employee> getEmployeeById(@RequestParam long employeeId){
        return employeeService.getEmployeById(employeeId);
    }
    @PostMapping("Create_a_new_employee")
    public ResponseEntity<String> addEmploye(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @PutMapping("update_employee_with_id")
    public ResponseEntity<String> updayeEmployeById(@RequestParam long employeId,@RequestBody Employee employee){
        return employeeService.updateEmployeeById(employeId,employee);
    }
    @DeleteMapping("delete_employe_by_id")
    public ResponseEntity<String> deleteEmploye(@RequestParam long id){
        return employeeService.deleteEmployeById(id);
    }
}
