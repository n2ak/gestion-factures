package com.factures.kafka.mappers;

import com.factures.kafka.dto.BillingRequest;
import com.factures.kafka.entities.Bill;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-09T01:55:21+0000",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class BillMapperImpl implements BillMapper {

    @Override
    public BillingRequest billToBillRequest(Bill request) {
        if ( request == null ) {
            return null;
        }

        BillingRequest billingRequest = new BillingRequest();

        billingRequest.setId( request.getId() );
        billingRequest.setCustomerId( request.getCustomerId() );

        return billingRequest;
    }
}
