package com.example.NortwindTradersSpringBoot.cli;

import com.example.NortwindTradersSpringBoot.cli.screen.CustomerListScreen;
import com.example.NortwindTradersSpringBoot.cli.screen.MenuScreen;
import com.example.NortwindTradersSpringBoot.cli.screen.ProductListScreen;
import com.example.NortwindTradersSpringBoot.service.CustomerService;
import com.example.NortwindTradersSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuHandler {
    private final MenuScreen menuScreen;
    private final CustomerListScreen customerListScreen;
    private final CustomerService customerService;
    private final ProductListScreen productListScreen;
    private final ProductService productService;
    private final Utils utils;

    public MenuHandler(MenuScreen menuScreen, CustomerListScreen customerListScreen, CustomerService customerService, ProductListScreen productListScreen, ProductService productService, Utils utils) {
        this.menuScreen = menuScreen;
        this.customerListScreen = customerListScreen;
        this.customerService = customerService;
        this.productListScreen = productListScreen;
        this.productService = productService;
        this.utils = utils;
    }

    @Autowired
    public void showMainMenu() {
        menuScreen.displayMenu();
        String option = utils.getUserInput();
        handleUserOption(option);
    }

    private void handleUserOption(String option) {
        switch (option) {
            case "0" -> exitScreen();
            case "1" -> showAllCustomers();
            case "2" -> System.out.println("@Todo - add customers");
            case "3" -> System.out.println("@Todo - delete customers");
            case "4" -> showAllProducts();
            default -> {
                System.out.println("Invalid option. Please try again.");
                showMainMenu();
            }
        }
    }

    private void showAllCustomers() {
        customerListScreen.displayAllCustomers(customerService.getAllCustomers());
        utils.pauseBriefly();
        showMainMenu();
    }

    private void showAllProducts() {
       productListScreen.displayAllProducts(productService.getAllProduct());
        utils.pauseBriefly();
        showMainMenu();
    }

    private void exitScreen() {
        System.out.println("Thank you for visiting the Northwind Data Service");
        System.out.println("System Exited");
        System.exit(0);
    }

}
