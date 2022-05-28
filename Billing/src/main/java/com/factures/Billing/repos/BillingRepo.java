package com.factures.Billing.repos;

import com.factures.Billing.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepo extends JpaRepository<Bill,Long> {
}
