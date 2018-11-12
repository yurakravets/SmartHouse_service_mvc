package com.ua.dao;

import com.ua.models.Customer;
import com.ua.models.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceDAO extends JpaRepository<Device,Integer> {
    List<Device> findAllByCustomer(Customer customer);
}
