package com.factures.Billing.feign;


import com.factures.Billing.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("CUSTOMER-SERVICE")
public interface CustomerService {
    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable(name="id") Long id);
}