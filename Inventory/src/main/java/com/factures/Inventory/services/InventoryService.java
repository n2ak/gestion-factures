package com.factures.Inventory.services;

import com.factures.Inventory.dto.ProductRequest;
import com.factures.Inventory.dto.ProductResponse;

import java.util.List;

public interface InventoryService {
    ProductResponse save(ProductRequest req);
    ProductResponse getById(ProductRequest req);
    List<ProductResponse> getAll();
    void delete(ProductRequest req);
}
