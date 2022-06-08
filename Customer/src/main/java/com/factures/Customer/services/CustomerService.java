package com.factures.Customer.services;

import com.factures.Customer.dto.CustomerRequest;
import com.factures.Customer.dto.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse save(CustomerRequest req);
    CustomerResponse getById(CustomerRequest req);
    List<CustomerResponse> getAll();
    void delete(CustomerRequest req);
}
