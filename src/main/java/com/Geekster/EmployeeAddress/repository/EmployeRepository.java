package com.Geekster.EmployeeAddress.repository;

import com.Geekster.EmployeeAddress.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends JpaRepository<Employee,Long> {
}
