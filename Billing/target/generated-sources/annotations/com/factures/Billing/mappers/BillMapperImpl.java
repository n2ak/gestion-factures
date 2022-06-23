package com.factures.Billing.mappers;

import com.factures.Billing.dto.BillingRequest;
import com.factures.Billing.dto.BillingResponse;
import com.factures.Billing.entities.Bill;
import com.factures.Billing.entities.ProductItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-22T04:34:11+0100",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class BillMapperImpl implements BillMapper {

    @Override
    public Bill billRequestToBill(BillingRequest request) {
        if ( request == null ) {
            return null;
        }

        Bill bill = new Bill();

        bill.setId( request.getId() );
        bill.setCustomerId( request.getCustomerId() );
        List<ProductItem> list = request.getProductItems();
        if ( list != null ) {
            bill.setProductItems( new ArrayList<ProductItem>( list ) );
        }

        return bill;
    }

    @Override
    public BillingResponse billToBillResponse(Bill customer) {
        if ( customer == null ) {
            return null;
        }

        BillingResponse billingResponse = new BillingResponse();

        billingResponse.setId( customer.getId() );
        billingResponse.setCustomerId( customer.getCustomerId() );
        List<ProductItem> list = customer.getProductItems();
        if ( list != null ) {
            billingResponse.setProductItems( new ArrayList<ProductItem>( list ) );
        }

        return billingResponse;
    }
}
