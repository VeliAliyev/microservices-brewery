package com.velialiyev.microservicesbrewery.services;

import com.velialiyev.microservicesbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto createNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);
}
