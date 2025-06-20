package com.example.NortwindTradersSpringBoot.controller;

import ch.qos.logback.core.joran.spi.HttpUtil;
import com.example.NortwindTradersSpringBoot.model.Customer;
import com.example.NortwindTradersSpringBoot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(path="/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}




