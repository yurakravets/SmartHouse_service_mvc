package com.ua.controllers;

import com.ua.models.Customer;
import com.ua.models.CustomerInfo;
import com.ua.models.Role;
import com.ua.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/reg/new_u")
    public String regUser(@RequestParam("usernamesignup") String username,
                          @RequestParam("email") String email,
                          @RequestParam("passwordsignup") String password, @RequestParam("passwordsignup_confirm") String password_confirm) {
        Customer customer = Customer.builder().username(username).password(password).build();
        customer.setCustomerInfo(CustomerInfo.builder().role(Role.ROLE_USER).customer(customer).email(email).build());

        customerService.save(customer);
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = customerService.activation(code);

        if (isActivated) {
            model.addAttribute("messageType", "success");
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("messageType", "danger");
            model.addAttribute("message", "Activation code is not found!");
        }

        return "login_reg";
    }
}
