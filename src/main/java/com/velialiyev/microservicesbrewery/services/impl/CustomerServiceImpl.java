package com.velialiyev.microservicesbrewery.services.impl;

import com.velialiyev.microservicesbrewery.services.CustomerService;
import com.velialiyev.microservicesbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Veli").build();
    }

    @Override
    public CustomerDto createNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).name(customerDto.getName()).build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Updating Customer...");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting Customer...");
    }
}
