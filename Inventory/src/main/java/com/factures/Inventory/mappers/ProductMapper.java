package com.factures.Inventory.mappers;

import com.factures.Inventory.dto.ProductRequest;
import com.factures.Inventory.dto.ProductResponse;
import com.factures.Inventory.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product productRequestToProduct(ProductRequest request);
    ProductResponse productToProductResponse(Product customer);
}
