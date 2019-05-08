package com.luv2code.spring.dao;

import com.luv2code.spring.entity.Customer;


import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
    void saveCustom(Customer custome);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
}
