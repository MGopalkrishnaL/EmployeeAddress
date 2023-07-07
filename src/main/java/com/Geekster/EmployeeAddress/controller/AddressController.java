package com.Geekster.EmployeeAddress.controller;

import com.Geekster.EmployeeAddress.model.Address;
import com.Geekster.EmployeeAddress.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping("get_all_addresses")
    public ResponseEntity<List<Address>> getAllAddress(){
       return addressService.getAllAddress();
    }
    @GetMapping("get_address_by_id")
    public ResponseEntity<Address> getAddressById(@RequestParam long addressId){
        return addressService.getAddressWithId(addressId);
    }
    @PostMapping("create_a_new_address")
    public ResponseEntity<String> saveAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }
    @PutMapping("update_an_address_by_id")
    public ResponseEntity<String> updateAddress(@RequestParam long addressId,@RequestBody Address address){
        return addressService.updateAddress(addressId,address);
    }
    @DeleteMapping("delete_an_address_by_id")
    public ResponseEntity<String> deleteAddress(@RequestParam long addressId){
        return addressService.deleteAddress(addressId);
    }
}

