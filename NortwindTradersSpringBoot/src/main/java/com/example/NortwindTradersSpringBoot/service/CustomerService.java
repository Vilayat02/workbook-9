package com.example.NortwindTradersSpringBoot.service;

import com.example.NortwindTradersSpringBoot.dao.CustomerDAO;
import com.example.NortwindTradersSpringBoot.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDao;

    @Autowired
    public CustomerService(CustomerDAO customerDao) {
        this.customerDao = customerDao;
    }

    public void addCustomer(Customer customer) {
        customerDao.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAll();
    }

}
