package com.factures.Customer.services;

import com.factures.Customer.entities.Customer;
import com.factures.Customer.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public void register(Customer c){
        repo.save(c);
    }

}
