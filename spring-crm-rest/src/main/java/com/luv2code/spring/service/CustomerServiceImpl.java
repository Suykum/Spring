package com.luv2code.spring.service;

import com.luv2code.spring.dao.CustomerDAO;
import com.luv2code.spring.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    // need inject customer dao
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustom(customer);
    }

    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }
}
