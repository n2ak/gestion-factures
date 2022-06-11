package com.factures.facturations_producer.feign;

import com.factures.facturations_producer.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient("INVENTORY-SERVICE")
public interface InventoryService {
    @GetMapping(value = "/products",headers = {"content-type:application/json"})
    List<Product> getAll();
}
