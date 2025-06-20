package com.example.NortwindTradersSpringBoot.dao;

import com.example.NortwindTradersSpringBoot.model.Customer;
import com.example.NortwindTradersSpringBoot.model.Product;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAOJDBCImpl implements ProductDAO{

    private List<Product> products;
    private DataSource dataSource;

    public ProductDAOJDBCImpl(DataSource dataSource) {
        this.products = new ArrayList<>();
        this.dataSource = dataSource;
    }


    @Override
    public List<Product> getAll() {
        this.products.clear();
        String sql = "SELECT ProductID, ProductName, CategoryID, UnitPrice FROM Products;";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rows = statement.executeQuery();
            while(rows.next()){
                this.products.add(new Product(rows.getInt(1), rows.getString(2), rows.getInt(3),rows.getBigDecimal(4)));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return this.products;
    }

    @Override
    public void delete() {

    }

    @Override
    public void add(Product product) {
        Customer createdCustomer = null;
        String sql = "INSERT INTO Customers (CompanyName, ContactName, ContactTitle) VALUES (?, ?, ?)";
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            statement.setString(1, customer.getCompanyName());
            statement.setString(2, customer.getContactName());
            statement.setString(3, customer.getContactTitle());

            statement.executeUpdate();

            // Retrieve the generated key
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                createdCustomer = getByCustomerID(generatedKeys.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
