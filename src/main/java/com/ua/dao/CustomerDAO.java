package com.ua.dao;

import com.ua.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Customer findByUsername(String username);

    Customer findCustomerByActivationCode(String code);
}
