package com.velialiyev.microservicesbrewery.web.controller;

import com.velialiyev.microservicesbrewery.services.CustomerService;
import com.velialiyev.microservicesbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID uuid){
        return new ResponseEntity<>(customerService.getCustomerById(uuid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createNewCustomer(@RequestBody CustomerDto customerDto){

        CustomerDto savedDto =  customerService.createNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity updateBeer(@PathVariable UUID uuid, @RequestBody CustomerDto customerDto){

        customerService.updateCustomer(uuid, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity deleteBeerById(@PathVariable UUID uuid){
        customerService.deleteById(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
