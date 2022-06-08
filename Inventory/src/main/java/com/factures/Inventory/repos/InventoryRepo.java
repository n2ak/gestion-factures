package com.factures.Inventory.repos;

import com.factures.Inventory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Product,String> {
}
