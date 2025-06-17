package com.example.NortwindTradersSpringBoot.dao;

import com.example.NortwindTradersSpringBoot.model.Customer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDAOJDBCImpl implements CustomerDAO{
    private List<Customer> customers;
    private DataSource dataSource;

    public CustomerDAOJDBCImpl(DataSource dataSource) {
        this.customers = new ArrayList<>();
        this.dataSource = dataSource;
    }

    @Override
    public List<Customer> getAll() {
        this.customers.clear();
        String sql = "SELECT CustomerID, CompanyName, ContactName, ContactTitle FROM Customers;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.customers.add(new Customer(rows.getString(1), rows.getString(2), rows.getString(3),rows.getString(4)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.customers;
    }

    @Override
    public List<Customer> getByCompanyName() {
        return List.of();
    }

    @Override
    public List<Customer> getByContactName() {
        return List.of();
    }

    @Override
    public List<Customer> getByAddress() {
        return List.of();
    }

    @Override
    public Customer getByCustomerID() {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public void add(Customer customer) {
        this.customers.add(customer);
    }
}
