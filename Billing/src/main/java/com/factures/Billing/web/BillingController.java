package com.factures.Billing.web;

import com.factures.Billing.entities.Bill;
import com.factures.Billing.repos.BillingRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BillingController {
    private BillingRepo repo;

    public BillingController(BillingRepo repo) {
        this.repo = repo;
    }
    @GetMapping(path = "/bills")
    public List<Bill> getCustomers(){
        return repo.findAll();
    }
    @GetMapping(path="/bills/{id}")
    public Bill getCustomer(Long id){
        return repo.findById(id).get();
    }
    @PostMapping(path = "/bills")
    public Bill addCustomer(@RequestBody Bill c){
        return repo.save(c);
    }
    @PutMapping(path = "/bills/{id}")
    public Bill updateBill(@PathVariable Long id, @RequestBody Bill c){
        c.setId(id);
        return repo.save(c);
    }
    @DeleteMapping(path = "/bills/{id}")
    public void deleteBill(@PathVariable Long id){
        repo.deleteById(id);
    }
}
