package com.factures.Customer.web;

import com.factures.Customer.entities.Customer;
import com.factures.Customer.repos.CustomerRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {
    private CustomerRepo repo;

    public CustomerController(CustomerRepo repo) {
        this.repo = repo;
    }
    @GetMapping(path = "/customers")
    public List<Customer> getCustomers(){
        return repo.findAll();
    }
    @GetMapping(path="/customers/{id}")
    public Customer getCustomer(Long id){
        return repo.findById(id).get();
    }
    @PostMapping(path = "/customers")
    public Customer addCustomer(@RequestBody Customer c){
        return repo.save(c);
    }
    @PutMapping(path = "/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer c){
        c.setId(id);
        return repo.save(c);
    }
    @DeleteMapping(path = "/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        repo.deleteById(id);
    }
}
