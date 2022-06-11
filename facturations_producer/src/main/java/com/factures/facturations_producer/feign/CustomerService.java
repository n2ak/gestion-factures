package com.factures.facturations_producer.feign;


import com.factures.facturations_producer.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


//@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerService {
    @GetMapping(value="/customers",headers = {"content-type:application/json"})
    List<Customer> getAll();
}