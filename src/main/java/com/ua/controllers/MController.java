package com.ua.controllers;

import com.ua.dao.CustomerDAO;
import com.ua.dao.DeviceDAO;
import com.ua.models.Customer;
import com.ua.models.Device;
import com.ua.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class MController {

    @Autowired
    DeviceDAO deviceDAO;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerDAO customerDAO;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/device/create")
    public String addDevice(){
        return "deviceadd";
    }

    @PostMapping("/reg/new_device")
    public String regDevice(Device device, Principal principal) {

        String name = principal.getName();
        Customer customer = customerService.findCustomerByUsername(name);
        System.out.println("zero");
        deviceDAO.save(device);
        System.out.println("first");
        device.setCustomer(customer);
        System.out.println("second");
        deviceDAO.save(device);
        System.out.println("third");
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model,Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        Customer customer = customerService.findCustomerByUsername(name);


        List<Device> devices = deviceDAO.findAllByCustomer(customer);

        model.addAttribute("devices",devices);

        return "home";
    }

    @GetMapping("device/{id}")
    public String deviceId(@PathVariable("id") int id, Model model){
        Device device = deviceDAO.findOne(id);
        device.getInput_reg();
        String[] arrSplit = device.getInput_reg().split(",");
        model.addAttribute("arr",arrSplit);
        model.addAttribute("device",device);

        return "device";
    }
}


