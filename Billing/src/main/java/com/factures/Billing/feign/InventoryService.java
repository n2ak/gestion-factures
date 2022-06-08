package com.factures.Billing.feign;

import com.factures.Billing.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("INVENTORY-SERVICE")
public interface InventoryService {
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable(name="id") String id);
}
