package com.factures.Customer.services;

import com.factures.Customer.dto.CustomerRequest;
import com.factures.Customer.dto.CustomerResponse;
import com.factures.Customer.mappers.CustomerMapper;
import com.factures.Customer.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;
    private CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepo repo, CustomerMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public CustomerResponse save(CustomerRequest req) {
        return mapper.customerToCustomerResponse(repo.save(mapper.customerRequestToCustomer(req)));
    }

    @Override
    public CustomerResponse getById(CustomerRequest req) {
        return mapper.customerToCustomerResponse(repo.findById(req.getId()).get());
    }

    @Override
    public List<CustomerResponse> getAll() {
        return repo.findAll().stream().map(p->mapper.customerToCustomerResponse(p)).collect(Collectors.toList());
    }

    @Override
    public void delete(CustomerRequest req) {
        repo.deleteById(req.getId());
    }
}
