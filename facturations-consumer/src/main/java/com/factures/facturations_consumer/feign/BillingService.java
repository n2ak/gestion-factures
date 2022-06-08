package com.factures.facturations_consumer.feign;


import com.factures.facturations_consumer.dto.BillingRequest;
import com.factures.facturations_consumer.dto.BillingResponse;
import com.factures.facturations_consumer.entities.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("BILLING-SERVICE")
public interface BillingService {

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    BillingResponse addBill(BillingRequest bill);
    //ResponseEntity<String> BillingResponse addBill(Bill bill);

}
