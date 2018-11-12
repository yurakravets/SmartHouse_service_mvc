package com.ua.dao;

import com.ua.models.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerInfoDAO extends JpaRepository<CustomerInfo, Integer> {
}
