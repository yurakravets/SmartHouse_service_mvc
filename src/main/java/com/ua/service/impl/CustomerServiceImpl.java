package com.ua.service.impl;

import com.ua.dao.CustomerDAO;
import com.ua.models.Customer;
import com.ua.models.Device;
import com.ua.service.CustomerService;
import com.ua.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setAccountNonExpired(true);
        customer.setAccountNonLocked(true);
        customer.setCredentialsNonExpired(true);
        customer.setActivated(false);
        customer.setActivationCode(UUID.randomUUID().toString());
        sendActivationMessage(customer);
        customerDAO.save(customer);
    }

    @Override
    public Customer findCustomerByUsername(String name) {
        return customerDAO.findByUsername(name);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public boolean activation(String code) {
        Customer customer = customerDAO.findCustomerByActivationCode(code);
        if (customer == null) {
            return false;
        }
        customer.setActivationCode(null);
        customer.setActivated(true);
        customerDAO.save(customer);
        return true;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerDAO.findByUsername(username);
    }

    private void sendActivationMessage(Customer customer) {
        if (!StringUtils.isEmpty(customer.getCustomerInfo().getEmail())) {
            String message = String.format(
                    "Hello, %s! \n" +
                            "Welcome to SmartHome. Please, visit next link: http://%s/activate/%s",
                    customer.getUsername(),
                    "localhost:8080",
                    customer.getActivationCode()
            );
            mailService.sendMail(customer.getCustomerInfo().getEmail(), message, "Activation code");
        }
    }
}
