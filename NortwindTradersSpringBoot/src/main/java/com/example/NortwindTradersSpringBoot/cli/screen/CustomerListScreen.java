package com.example.NortwindTradersSpringBoot.cli.screen;

import com.example.NortwindTradersSpringBoot.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerListScreen {

    public void displayAllCustomers(List<Customer> customers) {
        System.out.println("\n------------\n");
        customers.forEach(System.out::println);
    }
}
