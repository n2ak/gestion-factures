package com.factures.Billing.web;

import com.factures.Billing.dto.BillingRequest;
import com.factures.Billing.dto.BillingResponse;
import com.factures.Billing.services.BillingServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillingController {
    private BillingServiceImpl service;

    public BillingController(BillingServiceImpl service) {
        this.service = service;
    }
    @GetMapping(path = "/bills")
    public List<BillingResponse> getBills(){
        return service.getAll();
    }
    @GetMapping(path="/bills/{id}")
    public BillingResponse getBill(@PathVariable String id){
        return service.getById(new BillingRequest(id,null));
    }
    @PostMapping(path = "/bills")
    public BillingResponse addBill(@RequestBody BillingRequest c){
        return service.save(c);
    }
    @PutMapping(path = "/bills/{id}")
    public BillingResponse updateBill(@PathVariable BillingRequest c){
        return service.save(c);
    }
    @DeleteMapping(path = "/bills/{id}")
    public void deleteBill(@PathVariable String id){
        service.delete(new BillingRequest(id,null));
    }
}
