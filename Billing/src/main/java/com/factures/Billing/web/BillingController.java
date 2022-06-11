package com.factures.Billing.web;

import com.factures.Billing.dto.BillingRequest;
import com.factures.Billing.dto.BillingResponse;
import com.factures.Billing.services.BillingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Consumer;

@RestController
public class BillingController {
    @Autowired
    private BillingServiceImpl service;

    /*public BillingController(BillingServiceImpl service) {
        this.service = service;
    }*/
    @GetMapping(path = "/bills")
    public List<BillingResponse> getBills(){
        return service.getAll();
    }
    @GetMapping(path="/bills/{id}")
    public BillingResponse getBill(@PathVariable Long id){
        return service.getById(new BillingRequest(id,null,null));
    }
    @PostMapping(path = "/bills")
    public BillingResponse addBill(@RequestBody BillingRequest c){
        return service.save(c);
    }
    @PutMapping(path = "/bills/{id}")
    public BillingResponse updateBill(@PathVariable Long id,@RequestBody BillingRequest c){
        return service.save(c);
    }
    @DeleteMapping(path = "/bills/{id}")
    public void deleteBill(@PathVariable Long id){
        service.delete(new BillingRequest(id,null,null));
    }

    /*
    @Bean
    Consumer<BillingRequest> billCreation(){
        return req->{
            System.out.println("Creating bill: "+req.toString());
            service.save(req);
        };
    }
    */
}
