package com.Geekster.EmployeeAddress.service;

import com.Geekster.EmployeeAddress.model.Address;
import com.Geekster.EmployeeAddress.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public ResponseEntity<List<Address>> getAllAddress() {
        List<Address> addressList = addressRepository.findAll();
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    public ResponseEntity<Address> getAddressWithId(Long id) {
        Address address = addressRepository.findById(id).get();
        return new ResponseEntity<>(address,HttpStatus.OK);
    }

    public ResponseEntity<String> addAddress(Address address) {
        addressRepository.save(address);
        return new ResponseEntity<>("Address saved successfully",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> updateAddress(long addressId, Address address) {
        Address address1 = addressRepository.findById(addressId).get();
        address1.setCity(address.getCity());
        address1.setState(address.getState());
        address1.setStreet(address.getStreet());
        address1.setZipCode(address.getZipCode());
        address1.setAddressId(addressId);
        addressRepository.save(address1);
        return new ResponseEntity<>("Address has been updated successfully",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAddress(long addressId) {
        if(addressRepository.existsById(addressId)){
            addressRepository.deleteById(addressId);
            return new ResponseEntity<>("address has been deleted successfully",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("address with the id has not been found",HttpStatus.NOT_FOUND);
    }
}
