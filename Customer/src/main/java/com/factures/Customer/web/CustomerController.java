package com.factures.Customer.web;

import com.factures.Customer.dto.CustomerRequest;
import com.factures.Customer.dto.CustomerResponse;
import com.factures.Customer.services.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {
    private CustomerServiceImpl service;

    public CustomerController(CustomerServiceImpl service) {
        this.service = service;
    }
    @GetMapping(path = "/customers")
    public List<CustomerResponse> getCustomers(){
        return service.getAll();
    }
    @GetMapping(path="/customers/{id}")
    public CustomerResponse getCustomer(@PathVariable Long id){
        return service.getById(new CustomerRequest(id,null,null));
    }
    @PostMapping(path = "/customers")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest c){
        return service.save(c);
    }
    @PutMapping(path = "/customers/{id}")
    public CustomerResponse updateCustomer(@PathVariable CustomerRequest c){
        return service.save(c);
    }
    @DeleteMapping(path = "/customers/{id}")
    public void deleteCustomer(@PathVariable Long id){
        service.delete(new CustomerRequest(id,null,null));
    }
}
