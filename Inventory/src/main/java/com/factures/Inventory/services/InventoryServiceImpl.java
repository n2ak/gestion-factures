package com.factures.Inventory.services;

import com.factures.Inventory.dto.ProductRequest;
import com.factures.Inventory.dto.ProductResponse;
import com.factures.Inventory.mappers.ProductMapper;
import com.factures.Inventory.repos.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class InventoryServiceImpl implements InventoryService{

    @Autowired
    private InventoryRepo repo;
    private ProductMapper mapper;

    public InventoryServiceImpl(InventoryRepo repo, ProductMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public ProductResponse save(ProductRequest req) {
        req.setId(UUID.randomUUID().toString());
        return mapper.productToProductResponse(repo.save(mapper.productRequestToProduct(req)));
    }

    @Override
    public ProductResponse getById(ProductRequest req) {
        return mapper.productToProductResponse(repo.findById(req.getId()).get());
    }

    @Override
    public List<ProductResponse> getAll() {
        return repo.findAll().stream().map(p->mapper.productToProductResponse(p)).collect(Collectors.toList());
    }

    @Override
    public void delete(ProductRequest req) {
        repo.deleteById(req.getId());
    }
}
