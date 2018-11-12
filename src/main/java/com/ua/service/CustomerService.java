package com.ua.service;

import com.ua.models.Customer;
import com.ua.models.Device;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface CustomerService extends UserDetailsService {
    void save(Customer user);

    Customer findCustomerByUsername(String name);

    List<Customer> findAll();

    boolean activation(String code);

}
