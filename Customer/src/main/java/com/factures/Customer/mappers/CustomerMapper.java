package com.factures.Customer.mappers;

import com.factures.Customer.dto.CustomerRequest;
import com.factures.Customer.dto.CustomerResponse;
import com.factures.Customer.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer customerRequestToCustomer(CustomerRequest request);
    CustomerResponse customerToCustomerResponse(Customer customer);
}
