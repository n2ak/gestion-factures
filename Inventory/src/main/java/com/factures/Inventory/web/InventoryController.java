package com.factures.Inventory.web;

import com.factures.Inventory.dto.ProductRequest;
import com.factures.Inventory.dto.ProductResponse;
import com.factures.Inventory.services.InventoryServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class InventoryController {
    private InventoryServiceImpl service;

    public InventoryController(InventoryServiceImpl service) {
        this.service = service;
    }
    @GetMapping(path = "/products")
    public List<ProductResponse> getProducts(){
        return service.getAll();
    }
    @GetMapping(path="/products/{id}")
    public ProductResponse getProduct(@PathVariable String id){
        return service.getById(new ProductRequest(id,null,0));
    }
    @PostMapping(path = "/products")
    public ProductResponse addProduct(@RequestBody ProductRequest c){
        return service.save(c);
    }
    @PutMapping(path = "/products/{id}")
    public ProductResponse updateProduct(@PathVariable ProductRequest c){
        return service.save(c);
    }
    @DeleteMapping(path = "/products/{id}")
    public void deleteProduct(@PathVariable String id){
        service.delete(new ProductRequest(id,null,0));
    }
}
