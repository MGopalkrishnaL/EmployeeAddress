package com.Geekster.EmployeeAddress.repository;

import com.Geekster.EmployeeAddress.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

}
