package com.factures.facturations_producer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor public class Bill {
    private String id;
    private String customerId;
    private List<ProductItem> productItems;
}
@Data @NoArgsConstructor @AllArgsConstructor
class Customer {
    String id;
}
@Data @NoArgsConstructor @AllArgsConstructor
class ProductItem{
    private String id;
    private String productId;
    private Long quantity;
    private double price;
}
@Data @NoArgsConstructor @AllArgsConstructor
class Product {
    private String id;
    private String name;
    private double price;
}
