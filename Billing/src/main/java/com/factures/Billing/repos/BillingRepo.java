package com.factures.Billing.repos;

import com.factures.Billing.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepo extends JpaRepository<Bill,String> {
    List<Bill> findAllByCustomerId(String customerId);
}
