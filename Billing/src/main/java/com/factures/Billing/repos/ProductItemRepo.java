package com.factures.Billing.repos;

import com.factures.Billing.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ProductItemRepo  extends JpaRepository<ProductItem,String> {
    List<ProductItem> findAllByBillId(String billId);
}
